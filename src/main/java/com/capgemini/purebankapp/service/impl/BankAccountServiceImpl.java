package com.capgemini.purebankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.purebankapp.exception.InsufficientBalanceException;
import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;
import com.capgemini.purebankapp.repository.BankAccountRepository;
import com.capgemini.purebankapp.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankAccountRepository bankaccountrepository;

	@Override
	public double getBalance(long accountId) throws CustomerNotFoundException {
		try {
		return bankaccountrepository.getBalance(accountId);
		}
		catch(DataAccessException e){
			CustomerNotFoundException customerNotFound=new CustomerNotFoundException("Customer does not exist");
			customerNotFound.initCause(e);
			throw customerNotFound;
		}
	}

	@Override
	public double withdraw(long accountId, double amount) throws NegetiveBalanceException, CustomerNotFoundException {
		if(accountId==0) 
			throw new CustomerNotFoundException("Customer Not Found");
			
		if(getBalance(accountId)>=amount) {
		double accountBalance = bankaccountrepository.getBalance(accountId);
		bankaccountrepository.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;}
		throw new NegetiveBalanceException("Balance is low to make Transaction");
		
	}

	@Override
	public double deposit(long accountId, double amount)  {
		double accountBalance = bankaccountrepository.getBalance(accountId);
		bankaccountrepository.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws NegetiveBalanceException, InsufficientBalanceException, CustomerNotFoundException {
double accountBalanceFrom = bankaccountrepository.getBalance(fromAcc);
		
		if (accountBalanceFrom < amount) 
			throw new InsufficientBalanceException("There is no sufficient balance in your account!");
		else if (amount < 0)
			throw new NegetiveBalanceException("The amount cannot be negative!");
		else {
			withdraw(fromAcc, amount);
			deposit(toAcc, amount);
			
			return true;
	}
 
}
}
