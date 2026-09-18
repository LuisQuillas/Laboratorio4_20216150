package org.example.laboratorio4_20216150.repository;


import org.example.laboratorio4_20216150.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    List<Employee> findByLastNameContainingIgnoreCase(String lastName);

    List<Employee> findByJobId(String jobId);

    List<Employee> findBySalaryGreaterThan(BigDecimal salario);


    @Query("SELECT e FROM Employee e "
            + "WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :texto, '%')) "
            + "OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :texto, '%')) "
            + "ORDER BY e.employeeId")
    List<Employee> buscarPorNombre(@Param("texto") String texto);


    @Query(value = "SELECT * FROM employees WHERE job_id = :jobId", nativeQuery = true)
    List<Employee> buscarPorJobIdNativo(@Param("jobId") String jobId);


}
