package com.mx.examen.employee.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestEmployeeWorkedHourBean {
	
	private Long employeeId;
	private Integer workedHours;
	private LocalDate workedDate;

}
