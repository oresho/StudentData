package com.example.demo.student.Repository;

import com.example.demo.student.Entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepository
        extends JpaRepository<Home, Long> {
    @Query("SELECT h FROM Home h WHERE h.state = ?1 AND h.city = ?2")
    Optional<Home> findByState_City(String state, String city);

}
