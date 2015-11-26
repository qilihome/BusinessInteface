package com.weichat.boss.action.business;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.BusinessInfo;
import com.weichat.boss.service.business.impl.BusinessInfoService;

public class BusinessInfoAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(BusinessInfoAction.class);
	
	@Autowired
	private BusinessInfoService businessInfoService;
	
	
	public String save() throws IOException{
		String businessInfoJsonStr = request.getParameter("businessInfo");
		BusinessInfo businessInfo = (BusinessInfo)JSONObject.toBean(JSONObject.fromObject(businessInfoJsonStr), BusinessInfo.class);
		businessInfoService.save(businessInfo);
		int result = businessInfo.getBusinessID();
		System.out.print("BusinessID============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result + "");
		return null;
	}

	
	
	
}
