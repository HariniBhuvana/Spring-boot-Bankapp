package com.capgemini.purebankapp.service;

import com.capgemini.purebankapp.entities.Customer;
import com.capgemini.purebankapp.exception.PasswordChangeFailedException;
import com.capgemini.purebankapp.exception.CustomerNotFoundException;

public interface CustomerService {
	public Customer authenticate(Customer customer)  throws CustomerNotFoundException;
	 
	public Customer updateProfile(Customer customer) ;

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) throws PasswordChangeFailedException;
	public Customer addCustomer(Customer customer);

	public boolean deleteCustomer(long customerId);

}
