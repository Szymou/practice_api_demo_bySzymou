package modules.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 熟知宇某
 * @date 2021/7/30 15:55
 */
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter ：前");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter ：中1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter ：中2");
    }

    @Override
    public void destroy() {
        System.out.println("filter ：后");
    }
}
