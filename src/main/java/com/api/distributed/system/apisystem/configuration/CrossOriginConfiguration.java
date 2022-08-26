package com.api.distributed.system.apisystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebMvc
public class CrossOriginConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*");
    }

    @Bean
    CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.addAllowedHeader(CorsConfiguration.ALL);
//        configuration.setAllowCredentials( true );
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }

}
