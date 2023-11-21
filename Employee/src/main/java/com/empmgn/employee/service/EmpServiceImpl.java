package com.empmgn.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empmgn.employee.exception.EmployeeAlreadyExsits;
import com.empmgn.employee.model.Department;
import com.empmgn.employee.model.Employee;
import com.empmgn.employee.repository.Emprepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private Emprepository repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee addemployee(Employee emp) throws EmployeeAlreadyExsits {
		if (repo.existsById(emp.getEmpId())) {
			throw new EmployeeAlreadyExsits("Employee already exists " + emp.getEmpId());
		}
		Employee emp2 = repo.save(emp);
		return emp2;
	}

	@Override
	public List<Employee> allemployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Employee getempbyid(long EmpId) {
		Employee employee = repo.findById(EmpId).get();
		Department department = restTemplate
				.getForObject("http://localhost:8082/dept/get/" + employee.getDepartmentId(), Department.class);
		employee.setDepartmentdetails(department);
		return employee;
	}

	@Override
	public Employee updateemployee(Employee emp) {
		Employee employee = repo.save(emp);
		return employee;
	}

	public List<Employee> getbydepartmentId(long departmentId) {
		List<Employee> list = repo.findByDepartmentId(departmentId);
		return list;
	}

}
