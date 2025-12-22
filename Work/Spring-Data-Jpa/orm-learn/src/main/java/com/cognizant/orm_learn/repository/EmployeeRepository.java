package com.cognizant.orm_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.orm_learn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skills  where e.permanent=true")
    List<Employee> getAllPermanentEmployees();
    @Query(value="select AVG(e.salary) from Employee e where e.department.id=:deptId")
    double findAvgSalaryOfDept(@Param("deptId") int deptId);

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployeesNatively();

}
