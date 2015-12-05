package com.weichat.boss.service.customer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.CustomerMapper;
import com.weichat.boss.data.pojo.Customer;
import com.weichat.boss.service.customer.ICustomerService;

@Service("customerService")
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> query(Customer customer) {
		// TODO Auto-generated method stub
		return customerMapper.query(customer);
	}

}
