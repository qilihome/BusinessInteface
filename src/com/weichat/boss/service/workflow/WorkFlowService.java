package com.weichat.boss.service.workflow;

import java.util.List;

import com.weichat.boss.action.workflow.vo.WorkFlowVo;
import com.weichat.boss.data.pojo.WorkFlow;

/**
 * 流程节点
 * @author liqi
 * phone 18771970972
 * qq 197399622
 */
public interface WorkFlowService
{
	int saveOrUpdate(WorkFlow workFlow);
	
	List<WorkFlowVo> queryByBusinessInfoId(int businessInfoId);
}
