package com.example.demo.student.Entity;


import javax.persistence.*;

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

    @JoinColumn(name = "home_id",referencedColumnName = "id")
    private Long home_id;

    public Long getHome_id() {
        return home_id;
    }

    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    public Student() {
    }

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email, Long home_id) {
        this.name = name;
        this.email = email;
        this.home_id = home_id;
    }

    public Student(Long id, String name, String email, Long home_id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", home_id=" + home_id +
                '}';
    }
}
