package com.mx.examen.employee.service;

import com.mx.examen.employee.model.RequestEmployeeBean;
import com.mx.examen.employee.model.RequestEmployeeByJobBean;
import com.mx.examen.employee.model.RequestEmployeeWorkedHourBean;
import com.mx.examen.employee.model.RequestEmployeeFechasBean;
import com.mx.examen.employee.model.ResponseEmployeeBean;
import com.mx.examen.employee.model.ResponseEmployeeByJobBean;
import com.mx.examen.employee.model.ResponsePagoBean;
import com.mx.examen.employee.model.ResponseTotalWorkedHoursBean;

public interface IEmployeeService {
	
	ResponseEmployeeBean registraEmployee(RequestEmployeeBean requestEmployee);
	
	ResponseEmployeeBean registraEmployeeWorkedHour(RequestEmployeeWorkedHourBean requestEmployeeWorkedHour);
	
	ResponseEmployeeByJobBean searchEmployeesByJob(RequestEmployeeByJobBean jobRequest);
	
	ResponseTotalWorkedHoursBean getTotalWorkedHour(RequestEmployeeFechasBean requestTotalWorkedHour);
	
	ResponsePagoBean getPago(RequestEmployeeFechasBean requestPago);

}
