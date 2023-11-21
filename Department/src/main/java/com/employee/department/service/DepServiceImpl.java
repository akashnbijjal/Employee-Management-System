package com.employee.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.department.exception.DepartmentAlreadyExist;
import com.employee.department.exception.DepartmentNotFound;
import com.employee.department.model.Department;
import com.employee.department.model.Employee;
import com.employee.department.repository.DepRepository;
import com.employee.department.response.EmployeeResponse;

@Service
public class DepServiceImpl implements DepService {

	@Autowired
	private DepRepository repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Department createDepartment(Department department) {
		if (repo.existsById(department.getDepartmentId())) {
			throw new DepartmentAlreadyExist("Department Already exists with ID: " + department.getDepartmentId());
		}
		if (repo.existsByDepartmentName(department.getDepartmentName())) {
			throw new DepartmentAlreadyExist("Department Already exists with Name: " + department.getDepartmentName());
		}
		Department department2 = repo.save(department);
		return department2;
	}

	@Override
	public Department updateDepartment(Department updatedDepartment) {
		Department department = repo.save(updatedDepartment);
		return department;
	}

	@Override
	public Department getDepartmentById(long departmentId) {

		if (repo.existsById(departmentId)) {
			Department department = repo.findById(departmentId).get();

			List<EmployeeResponse> employeeResponse = restTemplate
					.getForObject("http://localhost:8081/emp/dept/" + department.getDepartmentId(), List.class);

			department.setEmployees(employeeResponse);

			return department;
		} else {
			throw new DepartmentNotFound("Department not found with ID: " + departmentId);
		}

	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> list = repo.findAll();
		return list;
	}

	@Override
	public String deleteDepartment(long departmentId) {
		if (repo.existsById(departmentId)) {
			repo.deleteById(departmentId);
			return "Department deleted!!!!!!!!!";
		} else {
			throw new DepartmentNotFound("Department not found with ID : " + departmentId);
		}

	}

	@Override
	public Department getempbydepartment(String departmentName) {
		Department department = repo.findByDepartmentNameContainingIgnoreCase(departmentName);
		return department;

	}

}
