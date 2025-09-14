package com.example.oidctest;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/", "/oauth2/**", "/login/**").permitAll()
                .requestMatchers("/userinfo").authenticated()
                .anyRequest().permitAll()
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/userinfo")
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
            );
        return http.build();
    }
}
