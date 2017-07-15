package filter;

public interface Filter {
    // 模拟HTTP请求/响应
    public void doFilter(Request request, Response response, FilterChain fc);
}
