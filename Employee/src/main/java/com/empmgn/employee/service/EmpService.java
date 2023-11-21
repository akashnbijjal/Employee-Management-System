package com.empmgn.employee.service;

import java.util.List;

import com.empmgn.employee.exception.EmployeeAlreadyExsits;
import com.empmgn.employee.model.Employee;

public interface EmpService {

	Employee addemployee(Employee emp) throws EmployeeAlreadyExsits;

	List<Employee> allemployees();

	Employee getempbyid(long EmpId);

	Employee updateemployee(Employee emp);
	
	
	
	
}
