package com.capgemini.purebankapp.controller;

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
import com.capgemini.purebankapp.exception.InsufficientBalanceException;
import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;
import com.capgemini.purebankapp.service.BankAccountService;

@Controller
@SessionAttributes("customer")
public class BankAccountController {

	@Autowired
	private BankAccountService bankaccountService;

	@RequestMapping(value = "/fundtransferPage", method = RequestMethod.GET)
	public String getfundTransferPage(HttpSession session, HttpServletRequest request, Model model) {
		session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("account", customer.getAccount());
		return "fundTransfer";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String transferFund( @RequestParam long toAcc, @RequestParam long amount,
			Model model, HttpSession session) throws NegetiveBalanceException, InsufficientBalanceException, CustomerNotFoundException {
		Customer customer = (Customer) session.getAttribute("customer");
		long fromAcc=customer.getAccount().getAccountId();
		bankaccountService.fundTransfer(fromAcc, toAcc, amount);
		model.addAttribute("success", true);
		return "success";
	}
}
