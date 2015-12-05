package com.weichat.boss.service.customer;

import java.util.List;

import com.weichat.boss.data.pojo.Customer;

public interface ICustomerService {
	List<Customer> query(Customer customer);
}
