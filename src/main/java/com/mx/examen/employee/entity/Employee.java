package com.mx.examen.employee.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "employees")
@NamedStoredProcedureQuery(name = "Employee.registraEmployee", 
procedureName = "transactions.registra_employee", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_gender_id", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_job_id", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_name", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_last_name", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_birthdate", type = LocalDate.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "l_id_employee", type = Long.class)})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idEmployee;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "BIRTHDAT")
	private LocalDate birthdate;
	
	@JoinColumn(name = "JOB_ID", referencedColumnName = "id")
    @ManyToOne
    private Job job;
	
	@JoinColumn(name = "GENDER_ID", referencedColumnName = "id")
    @ManyToOne
    private Gender gender;
	
	
	
	
}
