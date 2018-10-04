package com.capgemini.purebankapp.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.purebankapp.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public double getBalance(long accountId) throws DataAccessException {
		try {
			double balance = jdbctemplate.queryForObject("SELECT balance FROM bankaccount WHERE account = ?",
					new Object[] { accountId }, Double.class);
			return balance;
		} catch (DataAccessException e) {
			e.initCause(new EmptyResultDataAccessException("Expected 1 actual 0", 1));
			throw e;
		}
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance)  {
		
			int count= jdbctemplate.update("UPDATE bankaccount SET balance=? WHERE account=?",
					new Object[] { newBalance, accountId });
			return (count!=0)?true:false;
		
		
	}
}
