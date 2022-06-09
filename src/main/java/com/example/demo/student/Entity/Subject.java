package com.example.demo.student.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Subject")
@Table(name = "Subject")
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "enrolled_students",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
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

    public Subject(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void enrollStudents(Student student) {
        students.add(student);
    }
}
