package com.mx.examen.employee.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.mx.examen.employee.model.ErrorDescripcion;
import com.mx.examen.employee.model.ErrorDetails;

import lombok.Generated;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Value("${codigos.codErrorNoControlado}")
	private String codErrorNoControlado;

	@Value("${codigos.desErrorNoControlado}")
	private String desErrorNoControlado;

	@Value("${level.error}")
	private String error;

	@Value("${level.warning}")
	private String warning;

	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<ErrorDetails> customException(CustomException ex) {

		ErrorDetails errorResponse = crearErrorDetalle(ex.getMensaje(), ex.getCodigo(), ex.getNivel(),
				ex.getDescripcion(), ex.getDetalle());
		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatus().value()));

	}

	@Generated
	@ExceptionHandler(JsonParseException.class)
	public final ResponseEntity<ErrorDetails> handleJsonParseException(JsonParseException ex, WebRequest request) {

		ErrorDetails errorResponse = crearErrorDetalle(ex.getMessage(), codErrorNoControlado, error,
				desErrorNoControlado, "El json enviado no es correcto");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	
	@Generated
	@ExceptionHandler(HttpClientErrorException.class)
	public final ResponseEntity<ErrorDetails> handleHttpClientErrorException(HttpClientErrorException ex,
			WebRequest request) {
		ErrorDetails errorResponse = crearErrorDetalle(NestedExceptionUtils.getMostSpecificCause(ex).getMessage(),
				codErrorNoControlado, error, desErrorNoControlado,
				"Hubo un conflicto en el cliente, intentalo mas tarde");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@Generated
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorDetails> handleNullPointerException(NullPointerException e, WebRequest request) {
		ErrorDetails errorResponse = crearErrorDetalle(Arrays.toString(e.getStackTrace()), codErrorNoControlado, error,
				desErrorNoControlado, "Hubo un error verifique sus datos");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<MediaType> mediaTypes = ex.getSupportedMediaTypes();

		ErrorDetails errorResponse = crearErrorDetalle("El tipo de parametro soportado es " + mediaTypes.toString(),
				codErrorNoControlado, error, desErrorNoControlado, "El parametro no es soportado, verifique sus datos");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		pageNotFoundLogger.warn(ex.getMessage());
		Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();

		ErrorDetails errorResponse = crearErrorDetalle(
				"El tipo de petición soportado es " + supportedMethods.toString(), codErrorNoControlado, error,
				desErrorNoControlado, "El tipo de peticion no es soportado en este endpoint");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails errorResponse = crearErrorDetalle(ex.getCause().getMessage(), codErrorNoControlado, error,
				desErrorNoControlado, "El tipo de peticion no es soportado en este endpoint");

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@Generated
	private ErrorDetails crearErrorDetalle(String mensaje, String codigo, String nivel, String descripcion,
			String detalle) {
		ErrorDetails errorDetails = new ErrorDetails();
		ErrorDescripcion detail = new ErrorDescripcion();
		detail.setCodigo(codigo);
		detail.setDescripcion(descripcion);
		detail.setDetalle(detalle);
		detail.setNivel(nivel);
		detail.setMensaje(mensaje);

		List<ErrorDescripcion> errors = new ArrayList<>();
		errors.add(detail);
		errorDetails.setErrors(errors);
		return errorDetails;
	}
}