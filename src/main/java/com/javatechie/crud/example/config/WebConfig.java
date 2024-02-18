package com.javatechie.crud.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Replace with your allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Adjust allowed methods if needed
                .allowedHeaders("*"); // Consider specifying allowed headers for security in production

        // Optional: Allow credentials for cookies/session data (e.g., for authentication)
        // registry.addMapping("/**").allowCredentials(true);
    }
}
