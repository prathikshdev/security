package com.prathiksh.security.filter;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoggingFilter> registrationBean(){
            FilterRegistrationBean<LoggingFilter> loggingFilterFilterRegistrationBean =
            new FilterRegistrationBean<>();
            loggingFilterFilterRegistrationBean.setFilter(new LoggingFilter());
            loggingFilterFilterRegistrationBean.addUrlPatterns("/*");
            loggingFilterFilterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

        return loggingFilterFilterRegistrationBean;
    }

}
