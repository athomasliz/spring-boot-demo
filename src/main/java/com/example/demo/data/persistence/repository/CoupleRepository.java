package com.example.demo.data.persistence.repository;

import com.example.demo.data.persistence.model.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoupleRepository extends JpaRepository<Couple, String> {

    @Query("SELECT a FROM Couple a WHERE a.husband = :husband")
    List<Couple> findByHusband(@Param("husband") String husband);
}
