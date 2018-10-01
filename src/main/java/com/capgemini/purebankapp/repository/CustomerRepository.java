package com.capgemini.purebankapp.repository;

import com.capgemini.purebankapp.entities.Customer;

public interface CustomerRepository {
	public Customer authenticate(Customer customer);

	public Customer updateProfile(Customer customer);

	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);

	public Customer addCustomer(Customer customer);

	public boolean deleteCustomer(long customerId);

	
}
