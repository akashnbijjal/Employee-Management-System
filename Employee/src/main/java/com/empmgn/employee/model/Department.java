package com.empmgn.employee.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	@Id
	@JsonIgnore
	private long departmentId;
	private String departmentName;
	private String description;
	private String managerName;
	private String location;
}
