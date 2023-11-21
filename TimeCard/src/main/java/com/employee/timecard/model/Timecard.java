package com.employee.timecard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "TimeCard")
public class Timecard {

	@Id
	private long timecardId;

	private long empId;

	private String projectName;

	private Task task;

	private String date;

	private String hours;
	
	private Status status;

}
