package com.javatechie.crud.example.config;

import com.javatechie.crud.example.security.jwt.JwtConfigurer;
import com.javatechie.crud.example.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/api/products").authenticated() // Secure this endpoint
                .antMatchers(HttpMethod.GET, "/api/products/**").permitAll() // Allow GET requests to this endpoint
                .anyRequest().permitAll() // Allow other requests without authentication
            .and()
            .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
