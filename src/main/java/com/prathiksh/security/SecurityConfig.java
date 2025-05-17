//package com.prathiksh.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/h2-console/**","/v1/auth").permitAll()
//                        .anyRequest().authenticated()
//                ).csrf(csrf -> csrf
//                        .ignoringRequestMatchers("/h2-console/**")
//                        .disable())
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions.sameOrigin()))
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//
//    }
//
//
//}
