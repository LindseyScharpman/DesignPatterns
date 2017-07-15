package filter;

// 过滤敏感词
// 双向过滤器,doFilter前后的代码逻辑就是过滤
public class SensitiveWordsFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {

        String result = request.getContent().replaceAll("共产党", "***");
        request.setContent(result);
        System.out.println("【前向处理】:" + result);

        fc.doFilter(request, response, fc);

        result = response.getContent().replaceAll("中国", "&&");
        response.setContent(result);
        System.out.println("【反向处理】:" + result);
    }
}
