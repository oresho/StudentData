package com.example.demo.student.Service;

import com.example.demo.student.Entity.School;
import com.example.demo.student.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getSchools(){ return schoolRepository.findAll();}

    public void addSchool(School school){schoolRepository.save(school);}

    public void deleteSchool(Long schoolId){
        School school = schoolRepository.findById(schoolId).orElseThrow(
                () -> new IllegalStateException("Cannot find school with this Id"));
        schoolRepository.deleteById(schoolId);}

    @Transactional
    public void updateSchool(Long schoolId, String schoolName, String location){
        School school = schoolRepository.findById(schoolId).orElseThrow(
                () -> new IllegalStateException("Cannot find school with this Id"));
        school.setSchoolName(schoolName);
        school.setLocation(location);
    }

}
