package com.example.demo.student.Entity;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Student") // use persistence not hibernate, good practice to specify the student name.
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = "email")
        }
)
public class Student {
    @Id // creates identifier, with primary key, use persistence
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

//    public List<Subject> getSubjects() {
//        return subjects;
//    }

    public Student() {
    }

    public Student(Long id, String name, String email, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.subjects = subjects;
    }

    public Student(String name, String email, List<Subject> subjects) {
        this.name = name;
        this.email = email;
        this.subjects = subjects;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
