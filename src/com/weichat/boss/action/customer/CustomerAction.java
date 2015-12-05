package com.weichat.boss.action.customer;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Customer;
import com.weichat.boss.service.customer.impl.CustomerService;

public class CustomerAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(CustomerAction.class);
	
	@Autowired
	private CustomerService customerService;
	
	
	public String query() throws IOException{
		String customerStr = request.getParameter("customerStr");
		Customer customer = (Customer)JSONObject.toBean(JSONObject.fromObject(customerStr), Customer.class);
		List<Customer> list = customerService.query(customer);
		String result = JSONArray.fromObject(list).toString();
		System.out.print("result============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		return null;
	}

	
	
	
}
