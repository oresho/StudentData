package com.example.demo.student.Controller;

import com.example.demo.student.Dto.SchoolDto;
import com.example.demo.student.Entity.School;
import com.example.demo.student.Repository.StudentRepository;
import com.example.demo.student.Service.SchoolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/school")
    public List<School> getSchools(){return schoolService.getSchools();}

    @PostMapping
    public void postSchools(@RequestBody @Valid SchoolDto schoolDto){
        School school = new School();
        school = modelMapper.map(schoolDto,School.class);
        school.setStudents(studentRepository.unassignedStudents());
        schoolService.addSchool(school);
    }

    @PutMapping
    public void putSchools(
            @PathVariable ("{schoolId}") Long schoolId,
            @RequestParam(required = false) String schoolName,
            @RequestParam(required = false) String location){
        schoolService.updateSchool(schoolId,schoolName,location);
    }

    @DeleteMapping
    public void  deleteSchool(@PathVariable ("{schoolId}") Long schoolId){
        schoolService.deleteSchool(schoolId);
    }
}
