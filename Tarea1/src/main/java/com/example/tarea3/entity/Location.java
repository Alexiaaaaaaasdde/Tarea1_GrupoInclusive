package com.example.tarea3.controller;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    private Integer locationId;

    private String city;
}
