package com.example.Bai02_baitap.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component // danh dau class la 1 cai bean
// cha cua @Bean

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
