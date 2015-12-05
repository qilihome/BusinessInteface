package com.weichat.boss.action.business;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.action.business.vo.BusinessCondition;
import com.weichat.boss.action.business.vo.BusinessInfoVo;
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
		System.out.print("BusinessInfoAction.save-->BusinessID============="+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result + "");
		return null;
	}
	
	public String update() throws IOException{
		String businessInfoJsonStr = request.getParameter("businessInfo");
		BusinessInfo businessInfo = (BusinessInfo)JSONObject.toBean(JSONObject.fromObject(businessInfoJsonStr), BusinessInfo.class);
		businessInfoService.save(businessInfo);
		int result = businessInfo.getBusinessID();
		System.out.print("BusinessInfoAction.save-->BusinessID============="+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result + "");
		return null;
	}

	
	public void query() throws IOException{
		String businessConditionJsonStr = request.getParameter("businessCondition");
		BusinessCondition businessCondition = (BusinessCondition)JSONObject.toBean(JSONObject.fromObject(businessConditionJsonStr), BusinessCondition.class);
		String pageNo = request.getParameter("pageNo");
		List<BusinessInfoVo> list = businessInfoService.query(businessCondition, Integer.valueOf(pageNo));
		String result = JSONArray.fromObject(list).toString();
		System.out.print("BusinessInfoAction.query-->BusinessInfos============="+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		
	}
	
	public void queryToBusinesses() throws IOException{
		int operatorID = Integer.valueOf(request.getParameter("operatorID"));
		List<BusinessInfoVo> list = businessInfoService.queryToBusinesses(operatorID);
		String result = JSONArray.fromObject(list).toString();
		System.out.print("BusinessInfoAction.queryToBusinesses-->BusinessInfos============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
	}
	
	public void queryById() throws IOException{
		String businessInfoId = request.getParameter("businessInfoId");
		BusinessInfoVo businessInfoVo = businessInfoService.queryById(Integer.valueOf(businessInfoId));
		String result = JSONObject.fromObject(businessInfoVo).toString();
		System.out.print("BusinessInfoAction.query-->BusinessInfos============="+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		
	}
	
}
