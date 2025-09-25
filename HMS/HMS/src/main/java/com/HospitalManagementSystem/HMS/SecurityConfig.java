package com.HospitalManagementSystem.HMS;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Swagger/Postman ke liye disable
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/patient/**").hasRole("ADMIN") // patient endpoints only for ADMIN
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {}); // Basic Auth enable

        return http.build();
    }
}
