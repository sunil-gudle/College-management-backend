package com.dailycoding.restful_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDTO {
    private String name;
    private String location;
    private List<DepartmentDTO> departments;
}
