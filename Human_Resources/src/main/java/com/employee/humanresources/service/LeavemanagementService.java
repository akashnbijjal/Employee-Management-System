package com.employee.humanresources.service;

import java.util.List;

import com.employee.humanresources.model.LeaveManagement;
import com.employee.humanresources.model.LeaveRecord;

public interface LeavemanagementService {

	LeaveManagement applyleave(LeaveManagement leaveManagement,LeaveRecord leaveRecord);

	List<LeaveManagement> viewleave(long empId);

	
}
