package filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private List<Filter> chains = new ArrayList<>();
    private int index = 0;

    public FilterChain add(Filter f) {
        chains.add(f);
        return this;
    }

    public FilterChain remove(Filter f) {
        chains.remove(f);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        if (index >= chains.size()) {
            index = 0;
            return;
        }

        // 处理到最后一个Filter,把处理后的请求放到响应中去,然后反方向处理响应
        if (index == chains.size() - 1)
            response.setContent(request.getContent());
        chains.get(index++).doFilter(request, response, fc);
        //++index; //千万不能放在后面
    }
}
