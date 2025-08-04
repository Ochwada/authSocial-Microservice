package com.example.authSocials.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * *******************************************************
 * Package: com.example.authSocials.config
 * File: SecurityConfig.java
 * Author: Ochwada
 * Date: Monday, 04.Aug.2025, 11:25 AM
 * Description:
 * Objective: Used to define beans, settings, and application setup logic
 * *******************************************************
 */

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/",  "/my_login", "/oauth2/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                                .loginPage("/my_login")
                                .defaultSuccessUrl("/dashboard", true));  // Enables OAuth2 social login.html
        return  httpSecurity.build();
    }

}
