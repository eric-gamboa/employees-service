package com.mx.examen.employee.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestEmployeeBean {
	
	private Long genderId;
	private Long jobId;
	private String name;
	private String lastName;
	private LocalDate birthdate;

}
