package com.example.demo.student.Bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean//you only need one bean even if you have multiple entities
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
