package com.prathiksh.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Inside JwtAuthenticationFilter::doFilterInternal");
        if(!request.getServletPath().equals("/generate-token")){
            System.out.println("Process start");
             filterChain.doFilter(request,response);
        } else {
            System.out.println("JWT generation start");
            ObjectMapper objectMapper = new ObjectMapper();
            LoginRequest loginRequest = objectMapper.readValue(request.getInputStream(),LoginRequest.class);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());

            Authentication authentication =
                    authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if(authentication.isAuthenticated()) {
                String token = jwtUtil.generateToken(loginRequest.getUsername());
                System.out.println("Token generated successfully : " + token);
                response.setHeader("Authentication","Bearer " + token);
            }
        }
    }

}
