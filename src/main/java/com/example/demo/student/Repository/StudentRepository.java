package com.example.demo.student.Repository;

import com.example.demo.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    @Query(value = "SELECT * FROM student WHERE id > ?1", nativeQuery = true)
    List<Student> checkForAvailableStudent(Long id);
}
