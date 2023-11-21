package com.employee.timecard.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.timecard.model.Status;
import com.employee.timecard.model.Timecard;

public interface timecardrepository extends MongoRepository<Timecard, Long> {

	Timecard getByEmpId(long empId);

	List<Timecard> getByEmpIdAndStatus(long empId, Status rejected);

}
