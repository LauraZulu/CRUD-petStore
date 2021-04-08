package com.pets.pet.conf;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozeMapper {
    @Bean
    public Mapper beanMapper() {
        return new DozerBeanMapper();
    }
}
