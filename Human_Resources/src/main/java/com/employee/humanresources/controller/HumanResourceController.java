package com.employee.humanresources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.humanresources.model.Employee;
import com.employee.humanresources.model.EmployeeResponse;

@RestController
@RequestMapping("HR")
public class HumanResourceController {

	@Autowired
	private RestTemplate resttemplate;

	@GetMapping("{empId}")
	public ResponseEntity<EmployeeResponse> getempbyempid(@PathVariable("empId") long empId) {
		Employee emp = resttemplate.getForObject("http://localhost:8081/emp/get/" + empId, Employee.class);
		EmployeeResponse emp2 = new EmployeeResponse();
		emp2.setEmpId(empId);
		emp2.setEmail(emp.getEmail());
		emp2.setEmpname(emp.getEmpname());
		emp2.setPhoneNumber(emp.getPhoneNumber());
		emp2.setDepartmentId(emp.getDepartmentId());
		return new ResponseEntity<EmployeeResponse>(emp2, HttpStatus.ACCEPTED);
	}

}
