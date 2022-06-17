package com.mx.examen.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.examen.employee.model.RequestEmployeeBean;
import com.mx.examen.employee.model.RequestEmployeeByJobBean;
import com.mx.examen.employee.model.RequestEmployeeWorkedHourBean;
import com.mx.examen.employee.model.RequestEmployeeFechasBean;
import com.mx.examen.employee.model.ResponseEmployeeBean;
import com.mx.examen.employee.model.ResponseEmployeeByJobBean;
import com.mx.examen.employee.model.ResponsePagoBean;
import com.mx.examen.employee.model.ResponseTotalWorkedHoursBean;
import com.mx.examen.employee.service.IEmployeeService;

import io.swagger.annotations.ApiOperation;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@RestController
@EnableSwagger2
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	IEmployeeService employeeService;

	@ApiOperation(value = "Registra el employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/registra", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registra(@RequestBody RequestEmployeeBean request) {		
		ResponseEmployeeBean employee = employeeService.registraEmployee(request);
		
		return responseService(employee, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Registra el employee worked hourss")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/registra/worked_hours", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registraWorkedHours(@RequestBody RequestEmployeeWorkedHourBean request) {		
		ResponseEmployeeBean employeeWorkedHour = employeeService.registraEmployeeWorkedHour(request);
		
		return responseService(employeeWorkedHour, HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value = "Consulta employees by job")
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(value = "/consulta/employees/job", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaEmployeesByJob(@RequestBody RequestEmployeeByJobBean request) {		
		ResponseEmployeeByJobBean employeesByJob = employeeService.searchEmployeesByJob(request);
		
		return responseService(employeesByJob, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Consulta total worked hours")
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(value = "/consulta/total_worked_hours", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaTotalWorkedHours(@RequestBody RequestEmployeeFechasBean request) {		
		ResponseTotalWorkedHoursBean total = employeeService.getTotalWorkedHour(request);
		
		return responseService(total, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Consulta pago")
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(value = "/consulta/pago", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaPago(@RequestBody RequestEmployeeFechasBean request) {		
		ResponsePagoBean pago = employeeService.getPago(request);
		
		return responseService(pago, HttpStatus.OK);
	}
		
	public ResponseEntity<Object> responseService(Object payload, HttpStatus code) {
		return ResponseEntity.status(code).body(payload);
	}

}
