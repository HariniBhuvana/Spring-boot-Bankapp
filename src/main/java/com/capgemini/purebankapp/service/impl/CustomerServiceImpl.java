package com.capgemini.purebankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CustomizableThreadCreator;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.UserNotFoundException;
import com.capgemini.purebankapp.repository.impl.CustomerRepositoryImpl;
import com.capgemini.purebankapp.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepositoryImpl customerrepositoryimpl;
	@Override
	public Customer authenticate(Customer customer) throws UserNotFoundException {
		return customerrepositoryimpl.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerrepositoryimpl.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		
		return customerrepositoryimpl.updatePassword(customer, oldPassword, newPassword);
	}
 
}
