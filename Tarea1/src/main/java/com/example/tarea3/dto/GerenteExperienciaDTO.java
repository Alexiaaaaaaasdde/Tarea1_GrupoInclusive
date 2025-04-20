package com.example.tarea3.dto;

public class GerenteExperienciaDTO {
    private String nombreDepartamento;
    private String nombreGerente;
    private double salario;

    public GerenteExperienciaDTO(String nombreDepartamento, String nombreGerente, double salario) {
        this.nombreDepartamento = nombreDepartamento;
        this.nombreGerente = nombreGerente;
        this.salario = salario;
    }

    public String getNombreDepartamento() { return nombreDepartamento; }
    public String getNombreGerente() { return nombreGerente; }
    public double getSalario() { return salario; }
}
