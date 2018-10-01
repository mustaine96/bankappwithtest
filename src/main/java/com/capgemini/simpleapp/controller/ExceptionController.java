package com.capgemini.simpleapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = AccountNotFoundException.class)
	public String accountNotFound(HttpServletRequest request, AccountNotFoundException exception,Model model) {
System.out.println(exception);
		
//		request.setAttribute("name", "true");
//		//request.setAttribute("error", exception);
//		System.out.println(exception.getCause());
//		model.addAttribute("customer", new Customer());
		return "wrongCredentials";
	}
	
}
