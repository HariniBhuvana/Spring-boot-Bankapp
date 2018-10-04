/*package com.capgemini.purebankapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.PasswordChangeFailedException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;
import com.capgemini.purebankapp.exception.UpdationFailedException;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionController {
 @Autowired(required = false)
private Log logger=LogFactory.getLog(ExceptionController.class);
 public String handleException(HttpServletRequest req,Exception e) {
 logger.logError("Request"+req.getRequestURL()+"Threw an Exception",e);
 return "error";
 }
}
@ControllerAdvice
//for checking exceptions in all controllers
public class ExceptionController {

	// ExceptionHandler maps the exception to be checked
	@ExceptionHandler(value = CustomerNotFoundException.class)
	public String CustomerNotFoundException(HttpServletRequest request, CustomerNotFoundException exception,
			Model model) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception.toString());

		// System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = NegetiveBalanceException.class)
	public String negativeBalanceException(HttpServletRequest request, NegetiveBalanceException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception.toString());
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = PasswordChangeFailedException.class)
	public String passwordChangeFailedException(HttpServletRequest request, PasswordChangeFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception.toString());
		System.out.println(exception.getCause());
		return "success";
	}

	@ExceptionHandler(value = UpdationFailedException.class)
	public String updationFailedException(HttpServletRequest request, UpdationFailedException exception) {
		System.out.println(exception);
		request.setAttribute("success", false);
		request.setAttribute("error", exception.toString());
		System.out.println(exception.getCause());
		return "success";
	}


}*/