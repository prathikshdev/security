package com.prathiksh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u1 = User.withUsername("Prathiksh")
                .password("{noop}mar@2024")
                .roles("ADMIN")
                .build();
        UserDetails u2 = User.withUsername("Pallavi")
                .password("{noop}mar@2024")
                .roles("ADMIN")
                .build();
        UserDetails u3 = User.withUsername("Power")
                .password("{bcrypt}"+ new BCryptPasswordEncoder().encode("mar@2024"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(u1,u2,u3);
    }

    /*
    By default you want to have BCRYPT PasswordEncoder or any other encoder use like below code
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails u1 = User.withUsername("Prathiksh")
                .password(new BCryptPasswordEncoder().encode("Mar@2024"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(u1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     */

}
