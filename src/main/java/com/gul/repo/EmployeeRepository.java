package com.gul.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gul.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
