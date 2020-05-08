package com.capg.ewallet.fundtransfer.controller;

import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.fundtransfer.exceptions.UserNotFoundException;

@RestController
public class ErrorController {
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="User Not Found: Please enter valid details",
	code = HttpStatus.NOT_FOUND)
	public void handleUserNotFoundException() {
		
	}
	
	@ExceptionHandler(InputMismatchException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Enter valid inputs")
	public void handleOtherExceptions() {
		
	}

}
