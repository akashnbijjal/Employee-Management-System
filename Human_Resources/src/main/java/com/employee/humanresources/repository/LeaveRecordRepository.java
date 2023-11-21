package com.employee.humanresources.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.humanresources.model.LeaveRecord;

public interface LeaveRecordRepository extends MongoRepository<LeaveRecord, Long> {

	LeaveRecord getByEmpId(long empId);

}
