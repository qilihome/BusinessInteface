package com.weichat.boss.service.workflow.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.action.workflow.vo.WorkFlowVo;
import com.weichat.boss.data.dao.WorkFlowMapper;
import com.weichat.boss.data.pojo.WorkFlow;
import com.weichat.boss.service.workflow.WorkFlowService;
@Service("workFlowService")
@Transactional
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

	@Override
	public List<WorkFlowVo> queryByBusinessInfoId(int businessInfoId) {
		// TODO Auto-generated method stub
		return workflowMapper.queryByBusinessInfoId(businessInfoId);
	}

}
