package com.weichat.boss.data.dao;

import java.util.List;

import com.weichat.boss.action.workflow.vo.WorkFlowVo;
import com.weichat.boss.data.pojo.WorkFlow;

public interface WorkFlowMapper
{
	int save(WorkFlow workFlow);
	
	int update(WorkFlow workFlow);
	
	List<WorkFlowVo> queryByBusinessInfoId(int businessInfoId);
	
}