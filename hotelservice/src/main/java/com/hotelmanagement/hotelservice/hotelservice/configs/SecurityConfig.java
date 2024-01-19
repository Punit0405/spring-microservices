package com.hotelmanagement.hotelservice.hotelservice.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
        security.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        security.oauth2ResourceServer(res->res.jwt(Customizer.withDefaults()));
        return security.build();
    }
}
