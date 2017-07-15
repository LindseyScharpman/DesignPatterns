package filter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Request request = new Request("中国共产党，<p>那是真的好啊！</p><%=共产党好吗%><p>BIXUDE%></p>");

        FilterChain chain = new FilterChain();
        chain.add(new SensitiveWordsFilter())
                .add(new HtmlCodeFilter())
                .add(new JspTagFilter());

        Response response = new Response();
        chain.doFilter(request, response, chain);
        System.out.println(response.getContent());

        chain.doFilter(request, new Response(), chain);
        System.out.println(response.getContent());
    }
}
