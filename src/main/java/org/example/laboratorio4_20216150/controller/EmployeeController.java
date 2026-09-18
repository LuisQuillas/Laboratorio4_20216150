package org.example.laboratorio4_20216150.controller;

import org.example.laboratorio4_20216150.model.Employee;
import org.example.laboratorio4_20216150.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    // Inyeccion de dependencias por constructor (forma recomendada).
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/employees")
    public String listar(Model model) {
        List<Employee> empleados = employeeRepository.findAll();
        model.addAttribute("empleados", empleados);
        return "employees/list"; // -> templates/employees/list.html
    }

    /**
     * DATA BINDING (Lab 2, parte "databinding").
     * GET /employees/nuevo -> muestra el formulario vacio.
     * Se manda un objeto Employee "vacio" al Model: Thymeleaf usa sus
     * getters/setters (th:object / th:field) para pintar el formulario.
     */
    @GetMapping("/employees/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("empleado", new Employee());
        return "employees/form"; // -> templates/employees/form.html
    }

    /**
     * DATA BINDING (Lab 2, parte "databinding").
     * POST /employees -> Spring toma los campos del formulario (name="...")
     * y los "bindea" automaticamente a un objeto Employee gracias a
     * @ModelAttribute. No hace falta leer cada parametro a mano.
     *
     * IMPORTANTE: para el examen, si el enunciado pide que NO se use
     * save(), reemplaza esta linea por un metodo @Query + @Modifying +
     * @Transactional en el repositorio (ver patron en la Parte 5).
     */
    @PostMapping("/employees")
    public String guardar(@ModelAttribute("mascota") Employee mascota) {
        employeeRepository.save(mascota);
        return "redirect:/employees";
    }



    @GetMapping("/employees/buscar")
    public String buscar(@RequestParam(name = "texto", required = false, defaultValue = "") String texto,
                         Model model) {
        List<Employee> mascota = employeeRepository.buscarPorNombre(texto);
        model.addAttribute("e", mascota);
        model.addAttribute("texto", texto);
        return "employees/list";
    }
}

