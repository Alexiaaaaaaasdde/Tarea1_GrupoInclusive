package com.example.tarea3.employee;

import com.example.tarea3.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.jobId) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "CAST(e.departmentId AS string) LIKE CONCAT('%', :keyword, '%') OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Employee> search(String keyword);
}
