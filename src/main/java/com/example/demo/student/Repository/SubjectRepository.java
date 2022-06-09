package com.example.demo.student.Repository;

import com.example.demo.student.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    @Query(value = "SELECT * FROM subject WHERE LOWER(name) = ?1",nativeQuery = true)
    Optional<Subject> findSubjectByName(String name);
}
