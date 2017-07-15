package filter;

// 过滤JSP标签
public class JspTagFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {

        String result = request.getContent().replaceAll("<%", "[JSP<]").replaceAll("%>", "[JSP>]");
        request.setContent(result);
        System.out.println("【前向处理】:" + result);

        fc.doFilter(request, response, fc);

        result = response.getContent().replaceAll("真的", "[假的]");
        response.setContent(result);
        System.out.println("【反向处理】:" + result);
    }
}
