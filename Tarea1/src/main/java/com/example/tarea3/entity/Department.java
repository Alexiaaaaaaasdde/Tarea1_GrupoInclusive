package com.example.tarea3.entity;
@Entity
@Table(name = "departments")
public class Department {

    @Id
    private Integer departmentId;

    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
