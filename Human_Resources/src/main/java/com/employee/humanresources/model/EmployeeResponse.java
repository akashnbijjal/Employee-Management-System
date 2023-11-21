package com.employee.humanresources.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {

	@Id
	private long empId;
	private String empname;
	private String email;
	private String phoneNumber;
	private long departmentId;

}
