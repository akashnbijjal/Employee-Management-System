package com.empmgn.employee.controller;

import java.util.List;
import java.util.Map;

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
import com.empmgn.employee.exception.EmployeeAlreadyExsits;
import com.empmgn.employee.model.Employee;
import com.empmgn.employee.service.EmpServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("emp")
public class Empcontroller {

	@Autowired
	private EmpServiceImpl service;

	@Operation(summary = "Add a new employee", description = "Endpoint to add a new employee", operationId = "addEmployee")
	@PostMapping("addemployee")
	public ResponseEntity<Employee> addemp(@Valid @RequestBody Employee emp) throws EmployeeAlreadyExsits {
		Employee employee = service.addemployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@Operation(summary = "Get all the employees", description = "Endpoint to get all the employees", operationId = "getAllEmployees")
	@GetMapping("allemployees")
	public ResponseEntity<?> getemp() {
		Map<Long, List<Employee>> employee = service.allemployees();
		return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "Get emp by employeeid", description = "Endpoint to get employee by ID", operationId = "getEmployeebyID")
	@GetMapping("get/{EmpId}")
	public ResponseEntity<Employee> getempbyid(@PathVariable("EmpId") long EmpId) {
		Employee employee = service.getempbyid(EmpId);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}

	@Operation(summary = "update the employee", description = "Endpoint to update the employee", operationId = "updateEmployee")
	@PutMapping("update")
	public ResponseEntity<Employee> updateemp(@RequestBody Employee emp) {
		Employee employee = service.updateemployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping("dept/{departmentId}")
	public ResponseEntity<List<Employee>> getempbydept(@PathVariable("departmentId") long departmentId) {
		List<Employee> list = service.getbydepartmentId(departmentId);
		return new ResponseEntity<List<Employee>>(list, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("delete/{empId}")
	public ResponseEntity<String> deletebyid(@PathVariable("empId") long empId) {
		String delete = service.deletebyid(empId);
		return new ResponseEntity<String>(delete, HttpStatus.ACCEPTED);
	}

}
