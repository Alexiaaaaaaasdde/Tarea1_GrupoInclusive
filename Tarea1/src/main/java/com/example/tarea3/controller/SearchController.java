package com.example.tarea3.controller;

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
}