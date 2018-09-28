package com.capgemini.purebankapp.service;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.UserNotFoundException;

public interface CustomerService {
	public Customer authenticate(Customer customer)  throws UserNotFoundException;
	 
	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

}
