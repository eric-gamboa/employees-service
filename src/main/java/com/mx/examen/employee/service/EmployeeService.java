package com.mx.examen.employee.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.examen.employee.entity.Employee;
import com.mx.examen.employee.entity.Job;
import com.mx.examen.employee.model.RequestEmployeeBean;
import com.mx.examen.employee.model.RequestEmployeeByJobBean;
import com.mx.examen.employee.model.RequestEmployeeWorkedHourBean;
import com.mx.examen.employee.model.RequestEmployeeFechasBean;
import com.mx.examen.employee.model.ResponseEmployeeBean;
import com.mx.examen.employee.model.ResponseEmployeeByJobBean;
import com.mx.examen.employee.model.ResponsePagoBean;
import com.mx.examen.employee.model.ResponseTotalWorkedHoursBean;
import com.mx.examen.employee.repository.IEmployeeRepository;
import com.mx.examen.employee.repository.IEmployeeWorkedHourRepository;
import com.mx.examen.employee.repository.IJobRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;

	@Autowired
	IEmployeeWorkedHourRepository employeeWorkedHourRepository;

	@Autowired
	IJobRepository jobRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEmployeeBean registraEmployee(RequestEmployeeBean requestEmployee) {
		ResponseEmployeeBean response = new ResponseEmployeeBean();
		Long id = employeeRepository.registraEmployee(requestEmployee.getGenderId(), requestEmployee.getJobId(),
				requestEmployee.getName(), requestEmployee.getLastName(), requestEmployee.getBirthdate());
		response.setId(id);

		if (id != null)
			response.setSussess(true);

		return response;
	}

	@Override
	public ResponseEmployeeBean registraEmployeeWorkedHour(RequestEmployeeWorkedHourBean requestEmployeeWorkedHour) {
		ResponseEmployeeBean response = new ResponseEmployeeBean();
		Long id = employeeWorkedHourRepository.registraEmployeeWorkedHour(requestEmployeeWorkedHour.getWorkedHours(),
				requestEmployeeWorkedHour.getWorkedDate(), requestEmployeeWorkedHour.getEmployeeId());
		response.setId(id);

		if (id != null)
			response.setSussess(true);

		return response;
	}

	@Override
	public ResponseEmployeeByJobBean searchEmployeesByJob(RequestEmployeeByJobBean jobRequest) {
		ResponseEmployeeByJobBean employeeByJob = new ResponseEmployeeByJobBean();
		List<Employee> employees = new ArrayList<>();
		Optional<Job> job = jobRepository.findById(jobRequest.getJobId());

		if (job.isPresent())
			employees = employeeRepository.findByJob(job.get());

		if (!employees.isEmpty())
			employeeByJob.setSussess(true);

		employeeByJob.setEmployees(employees);

		return employeeByJob;
	}

	@Override
	public ResponseTotalWorkedHoursBean getTotalWorkedHour(RequestEmployeeFechasBean requestTotalWorkedHour) {
		ResponseTotalWorkedHoursBean response = new ResponseTotalWorkedHoursBean();
		Integer total = employeeWorkedHourRepository.getTotalWorkedHours(requestTotalWorkedHour.getEmployeeId(),
				requestTotalWorkedHour.getStartDate(), requestTotalWorkedHour.getEndDate());
		
		response.setTotalWorkedHours(total);
		if(total != null)
			response.setSussess(true);	
		
		return response;
	}

	@Override
	public ResponsePagoBean getPago(RequestEmployeeFechasBean requestPago) {
		ResponsePagoBean response = new ResponsePagoBean();
		BigDecimal pago = jobRepository.getPago(requestPago.getEmployeeId(),
				requestPago.getStartDate(), requestPago.getEndDate());
		
		response.setPago(pago);
		if(pago != null)
			response.setSussess(true);	
		
		return response;
	}

}
