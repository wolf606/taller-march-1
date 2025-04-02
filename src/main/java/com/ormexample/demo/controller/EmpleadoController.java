package com.ormexample.demo.controller;

import com.ormexample.demo.model.Empleado;
import com.ormexample.demo.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/by-salary")
    public ResponseEntity<List<Empleado>> getEmployeesBySalary(@RequestParam BigDecimal salary) {
        List<Empleado> employees = empleadoService.findBySalarioGreaterThan(salary);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/by-department")
    public ResponseEntity<List<Empleado>> getEmployeesByDepartment(@RequestParam String department) {
        List<Empleado> employees = empleadoService.findByDepartamento(department);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/count-by-department")
    public ResponseEntity<Long> countEmployeesByDepartment(@RequestParam String department) {
        long count = empleadoService.countByDepartamento(department);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/sorted-by-salary")
    public ResponseEntity<List<Empleado>> getEmployeesSortedBySalary() {
        System.out.println("sorted by salary");
        List<Empleado> employees = empleadoService.findAllOrderBySalarioDesc();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/by-email")
    public ResponseEntity<Empleado> getEmployeeByEmail(@RequestParam String email) {
        Empleado employee = empleadoService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }
}
