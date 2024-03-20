package com.inclub.apibackofficeadmin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
public class SpringSecurityConfig {
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		return http
                .authorizeExchange( auth -> {
                    auth
                        .pathMatchers("/banks").permitAll()
                        .pathMatchers("/users").permitAll()

                        .anyExchange().authenticated();
                }).httpBasic().disable()
                .formLogin().disable()
                .csrf().disable()
                .build();
	}
}
