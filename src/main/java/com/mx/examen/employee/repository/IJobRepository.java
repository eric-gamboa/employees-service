package com.mx.examen.employee.repository;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.examen.employee.entity.Job;

@Repository
public interface IJobRepository extends CrudRepository<Job, Long> {

	@Query(nativeQuery = true, value = "select querys.pago_employee(:p_employee_id,:p_start_date, :p_end_date) from dual")
	BigDecimal getPago(@Param("p_employee_id") long employeeId, @Param("p_start_date") LocalDate startDate, @Param("p_end_date") LocalDate endDate);
}
