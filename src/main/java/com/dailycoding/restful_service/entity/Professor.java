package com.dailycoding.restful_service.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String subject;

    // A Professor belongs to one Department
    // Professor table will have a department_id foreign key referencing the Department table.
    @ManyToOne
    @JsonBackReference
    private Department department;

}
