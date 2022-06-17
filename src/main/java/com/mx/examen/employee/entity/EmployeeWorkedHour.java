package com.mx.examen.employee.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_worked_hours")
@NamedStoredProcedureQuery(name = "EmployeeWorkedHour.registraEmployeeWorkedHour", 
procedureName = "transactions.registra_employee_worked_hours", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_employe_id", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_worked_hours", type = Integer.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_worked_date", type = LocalDate.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "l_id_employee_worked_hours", type = Long.class)})
public class EmployeeWorkedHour implements Serializable {

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private Long idEmployeeWorkedHour;
		
		@Column(name = "WORKED_HOURS")
		private Integer workedHours;	
		
		@Column(name = "WORKED_DATE")
		private LocalDate workedDate;

		
		@Column(name = "EMPLOYEE_ID")
		private Long employeeId;
		
		
}
