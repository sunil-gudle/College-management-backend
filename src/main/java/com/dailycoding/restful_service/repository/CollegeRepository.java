package com.dailycoding.restful_service.repository;

import com.dailycoding.restful_service.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<College, Integer> {
    @Query("SELECT c FROM College c LEFT JOIN FETCH c.departments d LEFT JOIN FETCH d.professors p LEFT JOIN FETCH d.students s WHERE c.id = :id")
    Optional<College> findByIdWithAllDetails(@Param("id") int id);
}
