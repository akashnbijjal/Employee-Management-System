package com.employee.humanresources.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.humanresources.model.LeaveManagement;

public interface Leavemanagementrepository extends MongoRepository<LeaveManagement, Long> {

	List<LeaveManagement> getByEmpId(long empId);

}
