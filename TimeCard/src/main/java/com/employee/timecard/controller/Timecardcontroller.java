package com.employee.timecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.timecard.model.Status;
import com.employee.timecard.model.Timecard;
import com.employee.timecard.service.TimeCardServiceImpl;

@RestController
@RequestMapping("timecard")
public class Timecardcontroller {

	@Autowired
	private TimeCardServiceImpl service;

	@PostMapping("timecardsummary")
	public ResponseEntity<Timecard> timecardsummary(@RequestBody Timecard timecard) {
		Timecard timecard2 = service.timecardsummary(timecard);
		return new ResponseEntity<Timecard>(timecard2, HttpStatus.CREATED);
	}

	@PutMapping("timecardadjustment/{empId}")
	public ResponseEntity<Timecard> timecardadjustment(@PathVariable("empId") long empId,
			@RequestBody Timecard timecard) {

		Timecard timecard2 = service.timecardadustment(empId, timecard);
		return new ResponseEntity<Timecard>(timecard2, HttpStatus.ACCEPTED);
	}

	@GetMapping("{empId}")
	public ResponseEntity<Timecard> gettimebyemployeeid(@PathVariable("empId") long empId) {
		Timecard timecard = service.gettimecardbyemployeeId(empId);
		return new ResponseEntity<Timecard>(timecard, HttpStatus.ACCEPTED);
	}

	@GetMapping("rejectedtimecard/{empId}/{status}")
	public ResponseEntity<List<Timecard>> rejectedtimecards(@PathVariable("empId") long empId,
			@PathVariable("status") Status status) {
		List<Timecard> timecard = service.rejectedtimecard(empId, status);
		return new ResponseEntity<List<Timecard>>(timecard, HttpStatus.ACCEPTED);
	}
	
	
}
