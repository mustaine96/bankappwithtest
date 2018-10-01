package com.capgemini.simpleapp.service;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;

public interface CustomerService {
	public Customer authenticate(Customer customer) throws AccountNotFoundException;
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer,String newPassword,String oldPassword);

}