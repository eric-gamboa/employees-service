package com.mx.examen.employee.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ResponsePagoBean {
	
	private BigDecimal pago;
	private boolean sussess;
	
	
}
