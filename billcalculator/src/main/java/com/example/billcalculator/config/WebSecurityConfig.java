package com.example.billcalculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorizeRequests) ->
                authorizeRequests
                    .requestMatchers("/api/calculate").authenticated()  // Require authentication for /api/calculate
                    .anyRequest().permitAll()  // Allow other requests without authentication
            )
            .httpBasic(Customizer.withDefaults());  // Correct method for HTTP Basic authentication in Spring Security 6.x

        // Disabling CSRF protection for API endpoints
        http.csrf((csrf) -> csrf.disable());
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Defining an in-memory user for testing purposes
        return username -> User.withUsername("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
    }
}
