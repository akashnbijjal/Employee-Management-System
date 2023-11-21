package com.employee.humanresources.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "leavemanagement")
public class LeaveManagement {

	@Id
	private long leaveId;

	private long empId;
	private String Empname;

	private Leavetype leavetype;

	private String startdate;

	private String enddate;

	private long leavebalance;

	private String reason;

}
