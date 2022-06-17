package com.mx.examen.employee.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.examen.employee.entity.Employee;
import com.mx.examen.employee.entity.Job;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

	@Procedure(name = "Employee.registraEmployee")
	Long registraEmployee(@Param("p_gender_id") long genderId, @Param("p_job_id") long jobId,
			@Param("p_name") String name, @Param("p_last_name") String lastName,
			@Param("p_birthdate") LocalDate birthdate);
	
	List<Employee> findByJob(Job job);
	
	 

}
