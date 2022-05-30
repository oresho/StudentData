package com.example.demo.student.Entity;

import javax.persistence.*;

@Entity(name = "school")
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "school_sequence", sequenceName = "school_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "school_sequence")
    private Long id;
    @Column(name = "schoolName", nullable = false,columnDefinition = "TEXT")
    private String schoolName;
    @Column(name = "location", nullable = false,columnDefinition = "TEXT")
    private String location;

    public School(Long id, String schoolName, String location) {
        this.id = id;
        this.schoolName = schoolName;
        this.location = location;
    }

    public School(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
