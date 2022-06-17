package com.mx.examen.employee.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.examen.employee.entity.EmployeeWorkedHour;

@Repository
public interface IEmployeeWorkedHourRepository extends CrudRepository<EmployeeWorkedHour, Long> {

	@Procedure(name = "EmployeeWorkedHour.registraEmployeeWorkedHour")
	Long registraEmployeeWorkedHour(@Param("p_worked_hours") int workedHours, @Param("p_worked_date") LocalDate workedDate,
			@Param("p_employe_id") long employeeId );
	
	@Query(nativeQuery = true, value = "select querys.total_worked_hours(:p_employee_id,:p_start_date, :p_end_date) from dual")
	Integer getTotalWorkedHours(@Param("p_employee_id") long employeeId, @Param("p_start_date") LocalDate startDate, @Param("p_end_date") LocalDate endDate);

}
