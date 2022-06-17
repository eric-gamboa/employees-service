package com.mx.examen.employee.model;

import java.util.List;

import com.mx.examen.employee.entity.Employee;

import lombok.Data;

@Data
public class ResponseEmployeeByJobBean {
	
	private List<Employee> employees;
	private boolean sussess;
	
	
}
