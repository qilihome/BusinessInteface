package com.weichat.boss.action.department;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Department;
import com.weichat.boss.service.department.DepartmentService;

public class DepartmentAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(DepartmentAction.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	
	
	public String list() throws IOException{
		List<Department> list = departmentService.list();
		String result = JSONArray.fromObject(list).toString();
		System.out.print("result============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		return null;
	}

	
	
}
