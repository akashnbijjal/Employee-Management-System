package com.empmgn.employee.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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

	@Size(min = 2,max = 20,message = "size should be with in 2 and 20")
	private String empname;

	private String address;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private double salary;
	private String isactive;
	private long departmentId;
	
	@Transient
	private Department departmentdetails;

}
