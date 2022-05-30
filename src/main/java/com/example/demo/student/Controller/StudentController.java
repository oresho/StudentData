package com.example.demo.student.Controller;

import com.example.demo.student.Dto.StudentDto;
import com.example.demo.student.Entity.Student;
import com.example.demo.student.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {


    @Autowired//injecting student service into the controller class using autowired annotation
    private StudentService studentService;
    /* public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }*/
    //injecting student service manually
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping//getting something out from our server
    public List<Student>  getStudents(){
        return studentService.getStudents();
     }

     @PostMapping
     public void registerNewStudent(@RequestBody @Valid StudentDto studentDto){
        Student student = new Student();
        student = modelMapper.map(studentDto,Student.class);
        studentService.addNewStudent(student);
     }

     @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
     }

     @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);
     }

}
