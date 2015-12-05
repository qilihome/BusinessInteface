package com.weichat.boss.data.dao;

import java.util.List;

import com.weichat.boss.data.pojo.Customer;

public interface CustomerMapper
{
	List<Customer> query(Customer customer);
	
}