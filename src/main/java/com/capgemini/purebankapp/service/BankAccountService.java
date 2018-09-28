package com.capgemini.purebankapp.service;

import com.capgemini.purebankapp.exception.InsufficientBalanceException;
import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.UserNotFoundException;

public interface BankAccountService {
	public double getBalance(long accountId) throws UserNotFoundException;

	public double withdraw(long accountId, double amount) throws UserNotFoundException, NegetiveBalanceException;

	public double deposit(long accountId, double amount) throws UserNotFoundException;

	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws NegetiveBalanceException, InsufficientBalanceException,UserNotFoundException;
}
