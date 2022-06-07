package com.example.demo.student.Dto;

import com.example.demo.student.Entity.Student;
import com.example.demo.student.Service.StudentService;
import com.example.demo.student.Validator.StateConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolDto {
    private Long id;
    private String schoolName;
    @StateConstraint
    private String location;

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public SchoolDto(Long id, String schoolName, String location) {
        this.id = id;
        this.schoolName = schoolName;
        this.location = location;
    }

    public SchoolDto(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    public SchoolDto() {
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
