package com.empmgn.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAlreadyExsits extends Exception {

	private static final long serialVersionUID = 1L;
	private String msg;

}
