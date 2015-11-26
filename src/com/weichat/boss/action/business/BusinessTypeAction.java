package com.weichat.boss.action.business;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.BusinessType;
import com.weichat.boss.service.business.impl.BusinessTypeService;

public class BusinessTypeAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(BusinessTypeAction.class);
	
	@Autowired
	private BusinessTypeService businessTypeService;
	
	
	
	public String list() throws IOException{
		List<BusinessType> list = businessTypeService.list();
		System.out.print("list.size============"+list.size());
		String result = JSONArray.fromObject(list).toString();
		System.out.print("BusinessTypes============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		return null;
	}

	
	
	
}
