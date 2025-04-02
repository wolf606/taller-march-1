package com.ormexample.demo.service;

import com.ormexample.demo.model.Empleado;
import com.ormexample.demo.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import com.ormexample.demo.exception.EmpleadoExceptions;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository userRepository) {
        this.empleadoRepository = userRepository;
    }

    public Empleado findByEmail(String email) {
        return empleadoRepository.findByEmail(email)
                .orElseThrow(() -> new EmpleadoExceptions.EmpleadoNotFoundException(email));
    }

    public List<Empleado> findBySalarioGreaterThan(BigDecimal salario) {
        return empleadoRepository.findBySalarioGreaterThan(salario);
    }

    public List<Empleado> findByDepartamento(String departamento) {
        return empleadoRepository.findByDepartamento(departamento);
    }

    public Long countByDepartamento(String departamento) {
        return empleadoRepository.countByDepartamento(departamento);
    }

    public List<Empleado> findAllOrderBySalarioDesc() {
        return empleadoRepository.findAllOrderBySalarioDesc();
    }
}
