package com.example.demo.student.Dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class StudentDto {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;
    private Long home_id;

    public Long getHome_id() {
        return home_id;
    }

    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    public StudentDto() {
    }

    public StudentDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public StudentDto(String name, String email, Long home_id) {
        this.name = name;
        this.email = email;
        this.home_id = home_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
