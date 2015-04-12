package com.leicui.springdemon.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class SpringMvcConfig {
    
    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();        
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix("*.jsp");
        return viewResolver;        
    }

}