package com.prathiksh.security.filter;


import jakarta.servlet.*;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("In Logging filter Before");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("In Logging filter After");
    }
}
