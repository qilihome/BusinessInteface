package com.weichat.boss.service.workflow.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.data.dao.WorkFlowMapper;
import com.weichat.boss.data.pojo.WorkFlow;
import com.weichat.boss.service.workflow.WorkFlowService;

public class WorkFlowServiceImpl implements WorkFlowService {

	@Autowired
	private WorkFlowMapper workflowMapper;

	@Override
	public int saveOrUpdate(WorkFlow workFlow) {
		// TODO Auto-generated method stub
		int result = 0;
		if (workFlow.getWorkFlowId() > 0) {
			result = workflowMapper.update(workFlow);
		} else {
			result = workflowMapper.save(workFlow);
		}
		return result;
	}

}
