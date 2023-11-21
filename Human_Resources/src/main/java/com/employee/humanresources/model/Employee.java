package com.employee.humanresources.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Employee")
public class Employee {

	@Id
	private long empId;

	private String empname;

	private String address;

	private String email;
	private String phoneNumber;
	private Date hireDate;
	private double salary;
	private boolean isActive;
	private long departmentId;

}