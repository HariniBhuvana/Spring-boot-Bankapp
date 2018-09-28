package com.capgemini.purebankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.InsufficientBalanceException;
import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.UserNotFoundException;
import com.capgemini.purebankapp.repository.BankAccountRepository;
import com.capgemini.purebankapp.repository.impl.BankAccountRepositoryImpl;
import com.capgemini.purebankapp.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankAccountRepositoryImpl bankaccountrepositoryimpl;

	@Override
	public double getBalance(long accountId) throws UserNotFoundException {
		return bankaccountrepositoryimpl.getBalance(accountId);
		}

	@Override
	public double withdraw(long accountId, double amount) throws UserNotFoundException, NegetiveBalanceException {
		double accountBalance = bankaccountrepositoryimpl.getBalance(accountId);
		bankaccountrepositoryimpl.updateBalance(accountId, accountBalance - amount);
		return accountBalance - amount;
		
	}

	@Override
	public double deposit(long accountId, double amount) throws UserNotFoundException {
		double accountBalance = bankaccountrepositoryimpl.getBalance(accountId);
		bankaccountrepositoryimpl.updateBalance(accountId, accountBalance + amount);
		return accountBalance + amount;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount)
			throws NegetiveBalanceException, InsufficientBalanceException, UserNotFoundException {
double accountBalanceFrom = bankaccountrepositoryimpl.getBalance(fromAcc);
		
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
