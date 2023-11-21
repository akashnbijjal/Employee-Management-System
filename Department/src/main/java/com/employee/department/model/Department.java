package com.employee.department.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.employee.department.response.EmployeeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Department")
public class Department {

	@Id
	private long departmentId;
	private String departmentName;
	private String description;
	private String managerName;
	private String location;

	@Transient
	private List<EmployeeResponse> employees=new ArrayList<>();

}
