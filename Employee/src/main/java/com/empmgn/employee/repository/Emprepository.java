package com.empmgn.employee.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.empmgn.employee.model.Employee;

public interface Emprepository extends MongoRepository<Employee, Long> {

	List<Employee> findByDepartmentId(long departmentId);

	

}
