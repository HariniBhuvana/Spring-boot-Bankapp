package com.capgemini.purebankapp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.purebankapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public double getBalance(long accountId) {
		double balance= jdbctemplate.queryForObject("SELECT balance FROM bankaccount WHERE account = ?",
				new Object[] { accountId }, Double.class);
return balance;
	}

	@Override
	public double updateBalance(long accountId, double newBalance) {
		return jdbctemplate.update("UPDATE bankaccount SET balance=? WHERE account=?",
				new Object[] { newBalance, accountId });
	}
}
