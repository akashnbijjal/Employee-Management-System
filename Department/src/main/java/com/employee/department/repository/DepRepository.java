package com.employee.department.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.department.model.Department;

public interface DepRepository extends MongoRepository<Department, Long>{

	Department findByDepartmentNameContainingIgnoreCase(String departmentName);

	boolean existsByDepartmentName(String departmentName);

}
