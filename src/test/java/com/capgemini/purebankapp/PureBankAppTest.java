package com.capgemini.purebankapp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.purebankapp.controller.CustomerController;
import com.capgemini.purebankapp.entities.BankAccount;
import com.capgemini.purebankapp.entities.Customer;

import com.capgemini.purebankapp.service.CustomerService;

public class PureBankAppTest {
	@InjectMocks
	 CustomerController customerController;
	@Mock
	 CustomerService customerService;
	 MockMvc mockMvc;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();
		
	}
	@Test
	public void testAuthenticate() throws Exception {
		Customer customer=new Customer();
		customer.setCustomerId(1234);
		customer.setPassword("1");
		
		Customer cust1=new Customer("Hari",1234,"gasd@mail.com","mumbai","1",LocalDate.now(),new BankAccount() );
		Customer cust2=new Customer(null,1234,null,null,"1",null,null);
		
		
		when(customerService.authenticate(customer)).thenReturn(cust1);
		mockMvc.perform(post("/login").param("custId", "1234").param("password", customer.getPassword())).andExpect(view().name("accountDetails"));

//		when(customerService.authenticate(cust2)).thenReturn(cust2);
//		mockMvc.perform(post("/login").flashAttr("customer", cust2)).andExpect(view().name("index"));
		//verify(customerService, times(1)).exists(customer);
	}

	@Test
	public void testLogout() throws Exception {
		mockMvc.perform(post("/logout")).andExpect(view().name("index"));
	}
	
	@Test
	public void testEditCustomer() {
	Customer cust1 = new Customer("Hari", 1234, "gasd@mail.com", "mumbai", "1", LocalDate.now(), new BankAccount());
	Customer cust2 = new Customer("A", 1234, "b@b", "pqr", "12", LocalDate.now(), new BankAccount());
	
	
	}

}


