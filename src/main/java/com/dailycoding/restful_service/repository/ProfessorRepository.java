package com.dailycoding.restful_service.repository;

import com.dailycoding.restful_service.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
