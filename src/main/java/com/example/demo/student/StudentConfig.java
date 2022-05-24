package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ore = new Student(
                    "ore",
                    "ore@gmail.com",
                    LocalDate.of(2002, Month.JULY,23)
            );
            Student sho = new Student(
                    "sho",
                    "sho@gmail.com",
                    LocalDate.of(2012, Month.AUGUST,18)
            );
            repository.saveAll(
                    List.of(ore,sho)
            );
        };
    }
}
