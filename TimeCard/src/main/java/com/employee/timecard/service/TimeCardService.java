package com.employee.timecard.service;

import java.util.List;

import com.employee.timecard.model.Status;
import com.employee.timecard.model.Timecard;

public interface TimeCardService {

	public Timecard timecardsummary(Timecard timecard);

	public Timecard timecardadustment(long empId, Timecard timecard);

	public Timecard gettimecardbyemployeeId(long EmpId);

	List<Timecard> rejectedtimecard(long EmpId,Status status );

}
