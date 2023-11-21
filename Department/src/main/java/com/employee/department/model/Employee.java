package com.employee.department.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private long empId;

	private String empname;

	private String address;

	private long departmentId;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private double salary;
	private boolean isActive;

}
