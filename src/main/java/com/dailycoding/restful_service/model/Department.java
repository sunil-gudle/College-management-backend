package com.dailycoding.restful_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    // A Department belongs to one College
    // Department table will have a foreign key column college_id referencing the College table.
    @ManyToOne
    private College college;

    // A Department can have many Professors so Association: One-to-Many

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Professor> professors;


    // A Department can have many Students so Association: One-to-Many

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students;
}
