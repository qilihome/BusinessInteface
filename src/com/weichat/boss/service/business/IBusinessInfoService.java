package com.weichat.boss.service.business;

import java.util.List;

import com.weichat.boss.action.business.vo.BusinessCondition;
import com.weichat.boss.action.business.vo.BusinessInfoVo;
import com.weichat.boss.data.pojo.BusinessInfo;

public interface IBusinessInfoService {
	int save(BusinessInfo businessInfo);
	int update(BusinessInfo businessInfo) ;

	List<BusinessInfoVo> query(BusinessCondition businessCondition);

	List<BusinessInfoVo> queryToBusinesses(int operatorID);
}
