package com.employee.humanresources.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "LeaveRecord")
public class LeaveRecord {

	@Id
	public long leaveRecordId;

	public long empId;

	public long carry_forward_from_previous_year;

	public long leave_credit;

	public long leave_debit;

	public long days_available;

}
