package com.example.demo.student.Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "school")
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "school_sequence", sequenceName = "school_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "school_sequence")
    private Long id;
    @Column(name = "schoolName", nullable = false,columnDefinition = "TEXT")
    private String schoolName;
    @Column(name = "location", nullable = false,columnDefinition = "TEXT")
    private String location;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "school_id")
    private List<Student> students;

//    public List<Student> getStudents() {//causing an infinite loop in the api tester.
//        return students;
//    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School(Long id, String schoolName, String location) {
        this.id = id;
        this.schoolName = schoolName;
        this.location = location;
    }

    public School(String schoolName, String location) {
        this.schoolName = schoolName;
        this.location = location;
    }

    public School(String schoolName, String location, List<Student> students) {
        this.schoolName = schoolName;
        this.location = location;
        this.students = students;
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

    public void setLocation(String location) {this.location = location;}


    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", location='" + location + '\'' +
                ", students=" + students +
                '}';
    }
}
