package com.capgemini.purebankapp.service;

import com.capgemini.purebankapp.exception.InsufficientBalanceException;
import com.capgemini.purebankapp.exception.NegetiveBalanceException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;

public interface BankAccountService {
	public double getBalance(long accountId) throws CustomerNotFoundException;

	public double withdraw(long accountId, double amount) throws CustomerNotFoundException, NegetiveBalanceException;

	public double deposit(long accountId, double amount) throws CustomerNotFoundException;

	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws NegetiveBalanceException, InsufficientBalanceException,CustomerNotFoundException;
}
