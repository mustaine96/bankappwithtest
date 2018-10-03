package com.capgemini.simpleapp.testcases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.simpleapp.controller.CustomerController;
import com.capgemini.simpleapp.entities.BankAccount;
import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.service.CustomerService;
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerService customerService;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("iciciHome"));
	}
	
	@Test
	public void testLogin()throws Exception{
		
		Customer customer= new Customer(123,null,"pass",null,null,null,null);
		Customer customer1= new Customer(123,"vipul","pass","pass","asd",LocalDate.now(),new BankAccount());

		when(customerService.authenticate(customer)).thenReturn(customer1);
		
		mockMvc.perform(post("/authenticate").flashAttr("customer", customer)).andExpect(view().name("dashboard")).andExpect(model().attribute("customer",customer1));
		
	}
	

}
