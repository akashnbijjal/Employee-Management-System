package com.employee.department.service;

import java.util.List;

import com.employee.department.model.Department;

public interface DepService {

	// Create a new department
	Department createDepartment(Department department);

	// Update an existing department
	Department updateDepartment(Department updatedDepartment);

	// Retrieve a department by its ID
	Department getDepartmentById(long departmentId);

	// Retrieve all departments
	List<Department> getAllDepartments();

	// Delete a department by its ID
	String deleteDepartment(long departmentId);
	
	public Department getempbydepartment(String departmentName);

}
