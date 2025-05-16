package com.dailycoding.restful_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
    private List<ProfessorDTO> professors;
    private List<StudentDTO> students;
}
