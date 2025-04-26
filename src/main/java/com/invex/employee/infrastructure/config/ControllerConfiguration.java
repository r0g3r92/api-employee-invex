package com.invex.employee.infrastructure.config;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * This component is by configure all apis 
 */
@Configuration
@Slf4j
public class ControllerConfiguration implements WebMvcConfigurer,Filter{

    /**
     * Method by add cors, methods and headers that are allowed 
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
                .allowedOrigins("*") 
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*") 
                .exposedHeaders("Authorization", "Content-Type") 
                .allowCredentials(false);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
         HttpServletRequest httpRequest = (HttpServletRequest) request;

        log.info("***Headers of Request****");
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = httpRequest.getHeader(name);
            log.info("Header ** {}:{}",name,value);
        }
        log.info("***=====================****");

        chain.doFilter(request, response);
    }
}
