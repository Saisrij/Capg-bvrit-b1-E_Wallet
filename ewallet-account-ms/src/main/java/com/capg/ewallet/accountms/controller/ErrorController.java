package com.capg.ewallet.accountms.controller;

import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.accountms.exceptions.UserAccountNotFoundException;

@RestController
@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(UserAccountNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="Account Not Found: Please enter valid details",
	code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
	}
	
	@ExceptionHandler(InputMismatchException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Enter correct inputs")
	public void handleOtherExceptions() {
		
	}

}

