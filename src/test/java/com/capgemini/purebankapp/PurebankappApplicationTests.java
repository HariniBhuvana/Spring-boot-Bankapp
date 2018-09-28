package com.capgemini.purebankapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.purebankapp.controller.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurebankappApplicationTests {

	@Test
	public void contextLoads() {
		CustomerController customerController=new CustomerController();
		String result=customerController.editPasswordPage();
		assertEquals(result, "changePassword");
	}

}
