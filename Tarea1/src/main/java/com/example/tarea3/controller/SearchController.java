package com.example.tarea3.controller;

import com.example.tarea3.dto.DepartamentoPorCiudadDTO;
import com.example.tarea3.dto.GerenteExperienciaDTO;
import com.example.tarea3.model.Employee;
import com.example.tarea3.repository.DepartmentRepository;
import com.example.tarea3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String indiceReportes() {
        return "search/indice";
    }

    @GetMapping("/salarios-altos")
    public String empleadosConAltoSalario(Model model) {
        List<Employee> empleados = employeeRepository.findBySalaryGreaterThan(15000);
        model.addAttribute("empleados", empleados);
        return "search/salarios_altos";
    }

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departamentos-por-ciudad")
    public String reporteDepartamentosPorCiudad(Model model) {
        List<DepartamentoPorCiudadDTO> resultados = departmentRepository.departamentosConMasDeTresEmpleados();
        model.addAttribute("resultados", resultados);
        return "search/departamentos_por_ciudad";
    }

    @GetMapping("/gerentes-experimentados")
    public String reporteGerentesConExperiencia(Model model) {
        List<GerenteExperienciaDTO> lista = departmentRepository.gerentesConExperienciaMayorA5();
        model.addAttribute("gerentes", lista);
        return "search/gerentes_experimentados";
    }


}