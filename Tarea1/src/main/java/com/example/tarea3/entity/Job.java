package com.example.tarea3.entity;
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    private String jobId;

    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;
}
