package com.library.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")//拦截所有请求

public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override//拦截到请求之后都会调用
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截的请求");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截的请求fangs");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
