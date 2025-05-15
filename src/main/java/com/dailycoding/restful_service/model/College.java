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
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    // A College can have many Departments so Association: One-to-Many
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    private List<Department> departments;


}
