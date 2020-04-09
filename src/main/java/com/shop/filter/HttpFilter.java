//package com.shop.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter(filterName = "HeaderFooter", urlPatterns = "/*")
//public class HttpFilter implements Filter {
//    private FilterConfig filterConfig;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        response.getWriter().println("<h3>HEADER</h3>");
//        chain.doFilter(request, response);
//        response.getWriter().println("<h3>FOOTER</h3>");
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
