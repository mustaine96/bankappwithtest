package com.capgemini.simpleapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.capgemini.simpleapp.entities.Customer;
import com.capgemini.simpleapp.exception.AccountNotFoundException;
import com.capgemini.simpleapp.repository.impl.CustomerRepositoryImpl;
import com.capgemini.simpleapp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepositoryImpl custImplObj;

	@Override
	public Customer authenticate(Customer customer)  throws AccountNotFoundException {
		
		try {
		return custImplObj.authenticate(customer);
		}
		catch(DataAccessException e) {
			AccountNotFoundException accountNotFound = new AccountNotFoundException("User does not exist!");
			accountNotFound.initCause(e);
			throw accountNotFound;
		}

	}

	@Override
	public Customer updateProfile(Customer customer) {
		return custImplObj.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String newPassword, String oldPassword) {
		return custImplObj.updatePassword(customer, newPassword, oldPassword);
	}

}