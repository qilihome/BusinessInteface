package com.weichat.boss.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weichat.boss.data.pojo.Customer;

public interface CustomerMapper
{
	List<Customer> query(@Param("customer") Customer customer,   @Param("pageNo") int pageNo);
	
}