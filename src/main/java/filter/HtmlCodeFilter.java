package filter;

// 过滤HTML代码元素
// 双向过滤器,doFilter前后的代码逻辑就是过滤
public class HtmlCodeFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {

        String result = request.getContent().replaceAll("<p>", "[HTML] ");
        request.setContent(result);
        System.out.println("【前向处理】:" + result);

        fc.doFilter(request, response, fc);

        result = response.getContent().replaceAll("好吗", "[不好吗]");
        response.setContent(result);
        System.out.println("【反向处理】:" + result);
    }
}
