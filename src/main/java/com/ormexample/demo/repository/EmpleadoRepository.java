package com.ormexample.demo.repository;

import com.ormexample.demo.model.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Empleado> findByEmail(String email) {
        TypedQuery<Empleado> query = entityManager.createQuery(
                "SELECT e FROM Empleado e WHERE e.email = :email", Empleado.class);
        query.setParameter("email", email);
        List<Empleado> empleados = query.getResultList();
        return empleados.isEmpty() ? Optional.empty() : Optional.of(empleados.get(0));
    }

    public List<Empleado> findBySalarioGreaterThan(BigDecimal salario) {
        TypedQuery<Empleado> query = entityManager.createQuery(
                "SELECT e FROM Empleado e WHERE e.salario > :salario", Empleado.class);
        query.setParameter("salario", salario);
        return query.getResultList();
    }

    public List<Empleado> findByDepartamento(String departamento) {
        TypedQuery<Empleado> query = entityManager.createQuery(
                "SELECT e FROM Empleado e WHERE e.departamento = :departamento", Empleado.class);
        query.setParameter("departamento", departamento);
        return query.getResultList();
    }

    public long countByDepartamento(String departamento) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(e) FROM Empleado e WHERE e.departamento = :departamento", Long.class);
        query.setParameter("departamento", departamento);
        return query.getSingleResult();
    }

    public List<Empleado> findAllOrderBySalarioDesc() {
        TypedQuery<Empleado> query = entityManager.createQuery(
                "SELECT e FROM Empleado e ORDER BY e.salario DESC", Empleado.class);
        return query.getResultList();
    }
}
