package com.example.tarea3.controller;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        List<Employee> empleados = (keyword == null || keyword.isEmpty()) ?
                employeeRepository.findAll() :
                employeeRepository.search(keyword);
        model.addAttribute("empleados", empleados);
        model.addAttribute("keyword", keyword);
        return "employee/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).orElse(null));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee";
    }
}
