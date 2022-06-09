package com.example.demo.student.Service;

import com.example.demo.student.Entity.Student;
import com.example.demo.student.Entity.Subject;
import com.example.demo.student.Repository.StudentRepository;
import com.example.demo.student.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Subject> getSubjects(){return subjectRepository.findAll();}

    public void addSubject(Subject subject){
        Optional<Subject> subjectOptional = subjectRepository.findSubjectByName(subject.getName().toLowerCase());
        if(subjectOptional.isPresent()){
            throw new IllegalStateException("Subject already exists");
        }else{
            subjectRepository.save(subject);
        }
    }

    public void  deleteSubject(Long id){
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Subject cannot be deleted, it does not exist"));
        subjectRepository.delete(subject);
    }

    @Transactional
    public void updateSubject(Long id, String name){
        Subject subject = subjectRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Subject cannot be updated, it does not exist"));
        subject.setName(name);
    }
    @Transactional
    public void enrollStudentToSubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new IllegalStateException("Student cannot be enrolled, subject does not exist")
        );
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student cannot be enrolled, student does not exist")
        );
        subject.enrollStudents(student);
        subjectRepository.save(subject);
    }
}
