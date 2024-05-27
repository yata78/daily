package com.example.daily.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    InMemoryUserDetailsManager userDetailService() {
        UserDetails admin = User
            .withUsername("admin")
            .password(passwordEncoder().encode("admin1234"))
            .roles("ADMIN")
            .build();
        UserDetails student = User
            .withUsername("student")
            .password(passwordEncoder().encode("student5678"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, student);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
        .permitAll())
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/").permitAll()
            .anyRequest().authenticated()
        );
        return http.build();
    }
}
