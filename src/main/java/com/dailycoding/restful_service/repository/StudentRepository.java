package com.dailycoding.restful_service.repository;

import com.dailycoding.restful_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
