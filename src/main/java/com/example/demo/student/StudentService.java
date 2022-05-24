package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //Specifies that this is a service class
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping //getting something out from our server
    public List<Student> getStudents(){
        return studentRepository.findAll(); //return List.of(
    }

    public void addNewStudent(Student student) {
        Optional <Student> studentOptional =studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email has already been used");
        }
        studentRepository.save(student);
        // System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with Id: " + studentId +
                    " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with Id: " + studentId +
                        " does not exist")
        );

        if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(),name)){
            Optional <Student> studentOptional =studentRepository
                    .findStudentByEmail(email);

            if(studentOptional.isPresent()){
                throw new IllegalStateException("email has already been used");
            }
            student.setEmail(email);
        }

    }
}
