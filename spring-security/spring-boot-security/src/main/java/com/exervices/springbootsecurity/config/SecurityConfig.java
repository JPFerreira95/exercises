package com.exervices.springbootsecurity.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class
 */
@EnableWebSecurity
public class SecurityConfig {

    // This version is out of date with the current spring boot version of this project

    // This code was extracted from dependency org/springframework/boot/spring-boot-autoconfigure/3.2.4/spring-boot-autoconfigure-3.2.4.jar!/org/springframework/boot/autoconfigure/security/servlet/SpringBootWebSecurityConfiguration.class
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }


}
