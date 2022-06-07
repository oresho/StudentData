package com.example.demo.student.Service;

import com.example.demo.student.Entity.School;
import com.example.demo.student.Entity.Student;
import com.example.demo.student.Repository.SchoolRepository;
import com.example.demo.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //Specifies that this is a service class
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

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
