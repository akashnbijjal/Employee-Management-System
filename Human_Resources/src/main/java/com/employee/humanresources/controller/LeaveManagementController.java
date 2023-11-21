package com.employee.humanresources.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.humanresources.model.LeaveManagement;
import com.employee.humanresources.model.LeaveRecord;
import com.employee.humanresources.service.LeaveManagementServiceImpl;



@RestController
@RequestMapping("leavemanagement")
public class LeaveManagementController {

	@Autowired
	private LeaveManagementServiceImpl service;

	@PostMapping("applyleave")
	public ResponseEntity<LeaveManagement> applyleave(@RequestBody LeaveManagement leaveManagement,
			@RequestBody LeaveRecord leaveRecord) {
		LeaveManagement leaveManagement2 = service.applyleave(leaveManagement, leaveRecord);
		return new ResponseEntity<LeaveManagement>(leaveManagement2, HttpStatus.CREATED);
	}

	@GetMapping("viewleave/{empId}")

	public ResponseEntity<List<LeaveManagement>> viewleaves(@PathVariable("empId") long empId) {
		List<LeaveManagement> list = service.viewleave(empId);
		return new ResponseEntity<List<LeaveManagement>>(list, HttpStatus.ACCEPTED);
	}

	@PostMapping("dashboard")
	public ResponseEntity<LeaveRecord> viewleavebalance(@RequestBody LeaveRecord leaveRecord) {
		LeaveRecord leaveRecord2 = service.viewleavebalance(leaveRecord);

		return new ResponseEntity<LeaveRecord>(leaveRecord2, HttpStatus.ACCEPTED);
	}

}
