package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp =(HttpServletResponse) servletRequest;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
