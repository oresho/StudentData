package com.example.demo.student.Dto;

import com.example.demo.student.Validator.StateConstraint;

import javax.validation.constraints.NotBlank;

public class HomeDto {
    private Long id;
    @NotBlank(message = "Please input state")
    @StateConstraint
    private String state;
    @NotBlank(message = "Please input city")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public HomeDto(Long id, String state, String city) {
        this.id = id;
        this.state = state;
        this.city = city;
    }

    public HomeDto(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public HomeDto() {
    }
}
