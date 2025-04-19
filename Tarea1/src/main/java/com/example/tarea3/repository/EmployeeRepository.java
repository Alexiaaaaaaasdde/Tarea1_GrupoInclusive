package com.example.tarea3.repository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Búsqueda por filtros
    @Query("SELECT e FROM Employee e " +
            "JOIN e.job j " +
            "JOIN e.department d " +
            "JOIN d.location l " +
            "WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(j.jobTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(l.city) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> search(@Param("keyword") String keyword);
}
