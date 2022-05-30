package com.example.demo.student.Repository;

import com.example.demo.student.Entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository
        extends JpaRepository<Home, Long> {

}
