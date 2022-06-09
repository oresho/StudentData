package com.example.demo.student.Controller;

import com.example.demo.student.Dto.SubjectDto;
import com.example.demo.student.Entity.Subject;
import com.example.demo.student.Service.StudentService;
import com.example.demo.student.Service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/subjects")
    public List<Subject> getSubjects(){return subjectService.getSubjects();}

    @PostMapping
    public void postSubject(@RequestBody @Valid SubjectDto subjectDto){
        Subject subject = new Subject();
        subject = modelMapper.map(subjectDto,Subject.class);
        subjectService.addSubject(subject);
    }

    @DeleteMapping(path = "{subjectId}")
    public  void deleteSubject(@PathVariable("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
    }

    @PutMapping(path = "{subjectId}")
    public  void putSubject(@PathVariable("subjectId") Long subjectId,
                            @RequestParam(required = false) String name){
        subjectService.updateSubject(subjectId,name);
    }

    @PutMapping(path = "{subjectId}/student/{studentId}")
    public  void enrollStudentToSubject(@PathVariable("subjectId") Long subjectId,
                                        @PathVariable("studentId") Long studentId){
        subjectService.enrollStudentToSubject(subjectId,studentId);
    }
}
