package com.employee.timecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timecard.exception.NomatchException;
import com.employee.timecard.model.Status;
import com.employee.timecard.model.Timecard;
import com.employee.timecard.repository.timecardrepository;

@Service
public class TimeCardServiceImpl implements TimeCardService {

	@Autowired
	private timecardrepository repo;

	@Override
	public Timecard timecardsummary(Timecard timecard) {
		Timecard timecard2 = repo.save(timecard);
		return timecard2;
	}

	@Override
	public Timecard timecardadustment(long empId, Timecard timecard) {
		timecard.setEmpId(empId);
		timecard.setProjectName(timecard.getProjectName());
		timecard.setHours(timecard.getHours());
		timecard.setStatus(timecard.getStatus());
		timecard.setTask(timecard.getTask());
		timecard.setTimecardId(timecard.getTimecardId());
		timecard.setDate(timecard.getDate());
		Timecard timecard2 = repo.save(timecard);
		return timecard2;
	}

	@Override
	public Timecard gettimecardbyemployeeId(long empId) {
		Timecard timecard = repo.getByEmpId(empId);
		return timecard;
	}

	@Override
	public List<Timecard> rejectedtimecard(long EmpId, Status status) {

		if (status == Status.Rejected) {
			List<Timecard> list = repo.getByEmpIdAndStatus(EmpId, Status.Rejected);
			return list;
		}
		throw new NomatchException("No matching records Found");
	}

}
