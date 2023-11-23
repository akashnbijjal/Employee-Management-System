package com.empmgn.employee.service;

import java.util.List;
import java.util.Map;

import com.empmgn.employee.exception.EmployeeAlreadyExsits;
import com.empmgn.employee.model.Employee;

public interface EmpService {

	Employee addemployee(Employee emp) throws EmployeeAlreadyExsits;

	Map<Long, List<Employee>> allemployees();

	Employee getempbyid(long empId);

	Employee updateemployee(Employee emp);
	
	String deletebyid(long empId);
	
	
	
	
}
