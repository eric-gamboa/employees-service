package com.mx.examen.employee.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Generated
@Slf4j
public class LoggingAspect {

	/**
	 * Pointcut that matches all repositories, services and Web REST endpoints.
	 */
	@Pointcut("within(@org.springframework.stereotype.Repository *)"
			+ " || within(@org.springframework.stereotype.Service *)"
			+ " || within(@org.springframework.web.bind.annotation.RestControllerAdvice *)"
			+ " || within(@org.springframework.stereotype.Component *)"
			+ " || within(@org.springframework.web.bind.annotation.RestController *)")
	@Generated
	public void springBeanPointcut() {
		// Method is empty as this is just a Pointcut, the implementations are in the
		// advices.
	}

	/**
	 * Pointcut that matches all Spring beans in the application's main packages.
	 */
	@Pointcut("within(com.mx.examen.employee..*)"
			+ " || within(com.mx.examen.employee.service..*)"
			+ " || within(com.mx.examen.employee.exception..*)"
			+ " || within(com.mx.examen.employee.controller..*)")
	@Generated
	public void applicationPackagePointcut() {
		// Method is empty as this is just a Pointcut, the implementations are in the
		// advices.
	}

	/**
	 * Advice that logs methods throwing exceptions.
	 *
	 * @param joinPoint join point for advice
	 * @param e         exception
	 */
	@AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "e")
	@Generated
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

		log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
	}

	/**
	 * Advice that logs when a method is entered and exited.
	 *
	 * @param joinPoint join point for advice
	 * @return result
	 * @throws Throwable throws IllegalArgumentException
	 */
	@Around("applicationPackagePointcut() && springBeanPointcut()")
	@Generated
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();

			log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), result);
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw e;
		}
	}

}
