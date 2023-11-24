package com.empmgn.employee.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empmgn.employee.exception.EmployeeAlreadyExsits;
import com.empmgn.employee.exception.EmployeeIdNotfound;
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
	public Map<Long, List<Employee>> allemployees() {

		Map<Long, List<Employee>> list = repo.findAll().stream()
				.sorted((e1, e2) -> e1.getEmpname().compareTo(e2.getEmpname()))
				.collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.toList()));
		return list;
	}

	@Override
	public Employee getempbyid(long empId) {
		Employee employee = repo.findById(empId).get();
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
		list.sort(Comparator.comparing(Employee::getEmpname));
		// list.sort((e1, e2) -> e1.getEmpname().compareTo(e2.getEmpname())); //old
		// method
		return list;
	}

	@Override
	public String deletebyid(long empId) {
		if (repo.existsById(empId)) {
			repo.deleteById(empId);
			return "Employee deleted sucessfully";

		} else {
			throw new EmployeeIdNotfound("Employee ID not found: " + empId);
		}

	}

	public Map<String, List<Employee>> listofactiveandinactiveemployees() {
		List<Employee> allEmployees = repo.findAll();
		Map<Boolean, List<Employee>> activeAndInactiveEmployees = allEmployees.stream()
				.collect(Collectors.partitioningBy(employee -> "active".equalsIgnoreCase(employee.getIsactive())));

		HashMap<String, List<Employee>> hashMap = new HashMap<>();
		hashMap.put("active", activeAndInactiveEmployees.getOrDefault(true, List.of()));
		hashMap.put("inactive", activeAndInactiveEmployees.getOrDefault(false, List.of()));
		return hashMap;
	}

}
