package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.WorkFlow;

public interface WorkFlowMapper
{
	int save(WorkFlow workFlow);
	
	int update(WorkFlow workFlow);
}