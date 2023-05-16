package com.portfolio.jh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Jhonny
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    public void addCoreMappingd(CorsRegistry registry){
            registry.addMapping("/**");
    }
}
