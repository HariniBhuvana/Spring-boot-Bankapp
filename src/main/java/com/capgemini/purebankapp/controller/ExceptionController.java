package com.capgemini.purebankapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.PasswordChangeFailedException;
import com.capgemini.purebankapp.exception.UserNotFoundException;
import com.capgemini.purebankapp.exception.UpdationFailedException;

import java.sql.SQLException;

/*@ControllerAdvice
public class ExceptionController {
 @Autowired(required = false)
private Log logger=LogFactory.getLog(ExceptionController.class);
 public String handleException(HttpServletRequest req,Exception e) {
 logger.logError("Request"+req.getRequestURL()+"Threw an Exception",e);
 return "error";
 }
}*/
@ControllerAdvice
//for checking exceptions in all controllers
public class ExceptionController {
@ExceptionHandler(value = UserNotFoundException.class)
//ExceptionHandler maps the exception to be checked
public String handlheError(HttpServletRequest request, UserNotFoundException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception.toString());
	
	//System.out.println(exception.getCause());
	return "success";
}
@ExceptionHandler(value = NegetiveBalanceException.class)
public String handlheErrorf(HttpServletRequest request, NegetiveBalanceException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}
@ExceptionHandler(value = PasswordChangeFailedException.class)
public String handlheErrorf(HttpServletRequest request, PasswordChangeFailedException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}

@ExceptionHandler(value = UpdationFailedException.class)
public String handlheErrorf(HttpServletRequest request, UpdationFailedException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}
@ExceptionHandler(value = SQLException.class)
public String handlheErrorf(HttpServletRequest request, SQLException exception) {
	System.out.println(exception);
	request.setAttribute("success", false);
	request.setAttribute("error", exception);
	System.out.println(exception.getCause());
	return "success";
}

}