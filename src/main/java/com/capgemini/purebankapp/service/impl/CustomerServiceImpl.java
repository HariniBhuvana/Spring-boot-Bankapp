package com.capgemini.purebankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.PasswordChangeFailedException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;
import com.capgemini.purebankapp.repository.CustomerRepository;
import com.capgemini.purebankapp.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerrepository;
	@Override
	public Customer authenticate(Customer customer) throws CustomerNotFoundException {
		try {
		return customerrepository.authenticate(customer);
		}
		catch(DataAccessException e)
		{
			CustomerNotFoundException u= new CustomerNotFoundException("Customer not found");
			u.initCause(e);
			throw u;}
		}

	@Override
	public Customer updateProfile(Customer customer){
	
		return customerrepository.updateProfile(customer);}
		


	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword)throws PasswordChangeFailedException {
		try {
			return customerrepository.updatePassword(customer, oldPassword, newPassword);
		}
		catch(DataAccessException e) {
			PasswordChangeFailedException passwordChangeFailedException=new PasswordChangeFailedException("Failed to change the password");
			passwordChangeFailedException.initCause(e);
			throw e;}
		
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerrepository.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		return customerrepository.deleteCustomer(customerId);
	}
	
 
}
