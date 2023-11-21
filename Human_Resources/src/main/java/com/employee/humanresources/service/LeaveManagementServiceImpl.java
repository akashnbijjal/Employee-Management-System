package com.employee.humanresources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.humanresources.model.LeaveManagement;
import com.employee.humanresources.model.LeaveRecord;
import com.employee.humanresources.repository.LeaveRecordRepository;
import com.employee.humanresources.repository.Leavemanagementrepository;

@Service
public class LeaveManagementServiceImpl implements LeavemanagementService {

	@Autowired
	private Leavemanagementrepository repo;

	@Autowired
	private LeaveRecordRepository leaveRecordRepository;

	@Override
	public LeaveManagement applyleave(LeaveManagement leaveManagement,LeaveRecord leaveRecord) {
		

		leaveManagement.setLeavebalance(leaveRecord.getDays_available());
		LeaveManagement leaveManagement2 = repo.save(leaveManagement);

		return leaveManagement2;
	}

	@Override
	public List<LeaveManagement> viewleave(long empId) {
		List<LeaveManagement> list = repo.getByEmpId(empId);
		return list;
	}

	public LeaveRecord viewleavebalance(LeaveRecord leaveRecord) {

		leaveRecord.setDays_available(leaveRecord.getCarry_forward_from_previous_year() + leaveRecord.getLeave_credit()
				- leaveRecord.getLeave_debit());
		LeaveRecord leaveRecord1 = leaveRecordRepository.save(leaveRecord);

		return leaveRecord1;
	}

}
