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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobileNo;

    // A Student belongs to one Department
    // Student table will have a department_id foreign key referencing the Department table.
    @ManyToOne
    @JsonBackReference
    private Department department;

}
