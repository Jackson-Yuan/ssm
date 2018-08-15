package com.yyc.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yyc on 2018/8/15.
 */
public class HttpFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    protected void init(){

    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        doFilter(request,response,filterChain);
    }

    public void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException{

    }

    @Override
    public void destroy() {

    }
}
