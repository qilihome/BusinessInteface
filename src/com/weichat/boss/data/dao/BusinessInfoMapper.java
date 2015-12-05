package com.weichat.boss.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weichat.boss.action.business.vo.BusinessCondition;
import com.weichat.boss.action.business.vo.BusinessInfoVo;
import com.weichat.boss.data.pojo.BusinessInfo;

public interface BusinessInfoMapper {
	int save(BusinessInfo businessInfo);
	int update(BusinessInfo businessInfo);
	
	List<BusinessInfoVo> query(@Param("businessCondition") BusinessCondition businessCondition, @Param("page") int page);
	
	List<BusinessInfoVo> queryToBusinesses(int operatorID);
	
	BusinessInfoVo queryById(int businessInfoId);
}
