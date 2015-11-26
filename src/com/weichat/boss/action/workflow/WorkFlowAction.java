package com.weichat.boss.action.workflow;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.WorkFlow;
import com.weichat.boss.service.workflow.WorkFlowService;

public class WorkFlowAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(WorkFlowAction.class);
	
	@Autowired
	private WorkFlowService workFlowService;
	
	
	private String workflowStr;
	
	public void saveOrUpdate() throws IOException{
		if (null != workflowStr){
			WorkFlow workFlow = (WorkFlow)JSONObject.toBean(JSONObject.fromObject(workflowStr), WorkFlow.class);
			workFlowService.saveOrUpdate(workFlow);
			response.setContentType("text/xml;charset=utf-8");
			this.getResponse().getWriter().write(workFlow.getWorkFlowId() + "");
		}
	}
	
	
}
