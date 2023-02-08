package com.example.ivanthreadlocal;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "Filter1", urlPatterns = "/*")
public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        LocalAccess.threadLocal.set("This is thread local accessed from: " + Thread.currentThread().getName());
        chain.doFilter(request, response);
    }
}
