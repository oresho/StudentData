package com.example.demo.student.Entity;

import javax.persistence.*;

@Entity(name = "Home")
@Table(name = "Home")
public class Home {
    @Id
    @SequenceGenerator(
            name = "home_sequence",
            sequenceName = "home_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "home_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "state", nullable = false, columnDefinition = "TEXT")
    private String state;
    @Column(name = "city", nullable = false, columnDefinition = "TEXT")
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

    public Home(Long id, String state, String city) {
        this.id = id;
        this.state = state;
        this.city = city;
    }

    public Home(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public Home() {
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
