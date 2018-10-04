package com.capgemini.purebankapp.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.PasswordChangeFailedException;

import com.capgemini.purebankapp.exception.CustomerNotFoundException;
import com.capgemini.purebankapp.service.CustomerService;

@Controller
@SessionAttributes("Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;
	
	
	@RequestMapping(value ="/login",method=RequestMethod.POST)
	public String authenticate(Model model, HttpServletRequest request, HttpSession session, @RequestParam long custId,
			@RequestParam String password) throws CustomerNotFoundException {
		Customer customer = new Customer(null, custId, null, null, password, null, null);

		customer = customerservice.authenticate(customer);

		if (customer.getEmail() != null) {
			model.addAttribute("customer", customer);
			session.setAttribute("customer", customer);
			return "accountDetails";
		}
		return "index";
	}
	@RequestMapping(value="/account")
	public String viewAccount(Model model,HttpSession session) {
			return "accountDetails";
	}
	
	
	@RequestMapping(value="/editCustomer")
	public String editProfilePage() {
		return "editCustomer";
	}
	
	
	@RequestMapping(value="/editprofile")
	public String editProfile(Model model,@RequestParam String custName, @RequestParam String custAddress,
			@RequestParam String custEmail, @RequestParam String custDOB, HttpSession session){
		
		Customer customer=(Customer)session.getAttribute("customer");
		
		customer.setAddress(custAddress);
		customer.setCustomerName(custName);
		customer.setEmail(custEmail);
		customer.setDateOfBirth(LocalDate.parse(custDOB));
		session.setAttribute("customer", customer);
		return "forward:/editCustomer";
			
	}
	
	@RequestMapping(value="/editPasswordPage")
	public String editPasswordPage() {
		return "changePassword";
	}
	
	@RequestMapping(value="/changePassword")
	public String editPassword(HttpSession session, @RequestParam String oldPassword, 
			@RequestParam String newPassword, HttpServletRequest request) throws PasswordChangeFailedException {
		Customer customer=(Customer)session.getAttribute("customer");
		customerservice.updatePassword(customer, oldPassword, newPassword);
		session.setAttribute("customer", customer);
		request.setAttribute("success", true);
		return "success";
		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}


}
