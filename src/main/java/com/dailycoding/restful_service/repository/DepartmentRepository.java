package com.dailycoding.restful_service.repository;

import com.dailycoding.restful_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
