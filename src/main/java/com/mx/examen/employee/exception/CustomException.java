package com.mx.examen.employee.exception;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.http.HttpStatus;

@ToString
@Setter
@Getter
@Generated
public class CustomException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8629116070527682827L;
	
	private final HttpStatus status;
	private final String mensaje;
	private final String codigo;
	private final String nivel;
	private final String descripcion;
	private final String detalle;
	
	public CustomException(HttpStatus status, String mensaje, String codigo,String nivel,String descripcion,String detalle) {
		super(mensaje);
		this.status = status;
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.nivel=nivel;
		this.descripcion=descripcion;
		this.detalle=detalle;
		
    }
}