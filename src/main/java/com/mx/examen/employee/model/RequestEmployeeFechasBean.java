package com.mx.examen.employee.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestEmployeeFechasBean {
	
	private Long employeeId;
	private LocalDate startDate;
	private LocalDate endDate;

}
