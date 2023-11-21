package com.employee.department.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.department.model.Department;
import com.employee.department.service.DepServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("dept")
public class DeptController {

	@Autowired
	private DepServiceImpl service;

	@Operation(summary = "Add a new department", description = "Endpoint to add a new department", operationId = "addDept")
	@PostMapping("adddepartment")
	public ResponseEntity<Department> adddepartment(@RequestBody Department department) {
		Department department2 = service.createDepartment(department);
		return new ResponseEntity<Department>(department2, HttpStatus.CREATED);
	}

	@Operation(summary = "get all departments", description = "Endpoint to get all departments", operationId = "getalldepartments")
	@GetMapping("alldepartments")
	public ResponseEntity<List<Department>> getalldepartments() {
		List<Department> list = service.getAllDepartments();
		return new ResponseEntity<List<Department>>(list, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "get department by id", description = "Endpoint to get department by id", operationId = "getdepartmentbyid")
	@GetMapping("get/{departmentId}")
	public ResponseEntity<Department> getdeptbyid(@PathVariable("departmentId") long departmentId) {
		Department department = service.getDepartmentById(departmentId);
		return new ResponseEntity<Department>(department, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "update the department", description = "Endpoint to update department", operationId = "updatedepartment")
	@PutMapping("updatedept")
	public ResponseEntity<Department> updatedepartment(@RequestBody Department department) {
		Department department2 = service.updateDepartment(department);
		return new ResponseEntity<Department>(department2, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Delete the department", description = "Endpoint to delete department", operationId = "deletedepartment")
	@DeleteMapping("delete/{departmentId}")
	public ResponseEntity<String> deletedepartment(@PathVariable("departmentId") long departmentId) {
		String department = service.deleteDepartment(departmentId);
		return new ResponseEntity<String>(department, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "get department by name", description = "Endpoint to get department by name",operationId = "departmentbyname" )
	@GetMapping("deptname/{departmentName}")
	public ResponseEntity<Department> getbydepartmentname(@PathVariable("departmentName") String departmentName) {
		Department department = service.getempbydepartment(departmentName);
		return new ResponseEntity<Department>(department, HttpStatus.ACCEPTED);
	}
}
