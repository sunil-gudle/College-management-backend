package com.dailycoding.restful_service.service;

import com.dailycoding.restful_service.entity.College;
import com.dailycoding.restful_service.entity.Department;
import com.dailycoding.restful_service.entity.Professor;
import com.dailycoding.restful_service.entity.Student;
import com.dailycoding.restful_service.model.CollegeDTO;
import com.dailycoding.restful_service.model.DepartmentDTO;
import com.dailycoding.restful_service.model.ProfessorDTO;
import com.dailycoding.restful_service.model.StudentDTO;
import com.dailycoding.restful_service.repository.CollegeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CollegeServiceImpl implements CollegeService{


    private final CollegeRepository collegeRepository;

    @Qualifier("mysqlDataSource")
    private final DataSource mysqlDataSource;

    @Override
    public College createCollege(CollegeDTO dto) {
        log.info("Using MySQL DataSource: {}", mysqlDataSource);
        log.info("Saving college: {}", dto.getName());
        College college = new College();
        college.setName(dto.getName());
        college.setLocation(dto.getLocation());

        List<Department> departments = new ArrayList<>();
        if (dto.getDepartments() != null) {
            for (DepartmentDTO d : dto.getDepartments()) {
                Department department = new Department();
                department.setName(d.getName());
                department.setCollege(college);

                // Professors
                List<Professor> profs = d.getProfessors() != null ?
                        d.getProfessors().stream().map(p -> {
                            Professor prof = new Professor();
                            prof.setName(p.getName());
                            prof.setSubject(p.getSubject());
                            prof.setDepartment(department);
                            return prof;
                        }).collect(Collectors.toList()) : new ArrayList<>();

                // Students
                List<Student> students = d.getStudents() != null ?
                        d.getStudents().stream().map(s -> {
                            Student student = new Student();
                            student.setName(s.getName());
                            student.setEmail(s.getEmail());
                            student.setMobileNo(s.getMobileNo());
                            student.setDepartment(department);
                            return student;
                        }).collect(Collectors.toList()) : new ArrayList<>();

                department.setProfessors(profs);
                department.setStudents(students);
                departments.add(department);
            }
        }

        college.setDepartments(departments);
        return collegeRepository.save(college);
    }

    @Override
    public Page<College> getAllColleges(Pageable pageable) {
        log.info("Using MySQL DataSource: {}", mysqlDataSource);
        log.info("Fetching all colleges");
        return  collegeRepository.findAll(pageable);
    }

    @Override
    public CollegeDTO getCollegeById(int id) {
        College college = collegeRepository.findByIdWithAllDetails(id)
                .orElseThrow(() -> new RuntimeException("College not found"));

        CollegeDTO dto = new CollegeDTO();
        dto.setName(college.getName());
        dto.setLocation(college.getLocation());

        List<DepartmentDTO> departmentDTOs = college.getDepartments().stream().map(dept -> {
            DepartmentDTO d = new DepartmentDTO();
            d.setName(dept.getName());

            List<ProfessorDTO> professors = dept.getProfessors().stream().map(p ->
                    new ProfessorDTO(p.getName(), p.getSubject())
            ).collect(Collectors.toList());

            List<StudentDTO> students = dept.getStudents().stream().map(s ->
                    new StudentDTO(s.getName(), s.getEmail(), s.getMobileNo())
            ).collect(Collectors.toList());

            d.setProfessors(professors);
            d.setStudents(students);
            return d;
        }).collect(Collectors.toList());

        dto.setDepartments(departmentDTOs);
        return dto;

    }
}
