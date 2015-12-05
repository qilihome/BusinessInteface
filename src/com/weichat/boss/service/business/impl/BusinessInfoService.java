package com.weichat.boss.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.action.business.vo.BusinessCondition;
import com.weichat.boss.action.business.vo.BusinessInfoVo;
import com.weichat.boss.data.dao.BusinessInfoMapper;
import com.weichat.boss.data.pojo.BusinessInfo;
import com.weichat.boss.service.business.IBusinessInfoService;

@Service("businessInfoService")
@Transactional
public class BusinessInfoService implements IBusinessInfoService {

	@Autowired
	private BusinessInfoMapper businessInfoMapper;

	@Override
	public int save(BusinessInfo businessInfo) {
		return businessInfoMapper.save(businessInfo);
	}
	
	@Override
	public int update(BusinessInfo businessInfo) {
		return businessInfoMapper.update(businessInfo);
	}

	@Override
	public List<BusinessInfoVo> query(BusinessCondition businessCondition) {
		// TODO Auto-generated method stub
		return businessInfoMapper.query(businessCondition);
	}

	@Override
	public List<BusinessInfoVo> queryToBusinesses(int operatorID) {
		// TODO Auto-generated method stub
		return businessInfoMapper.queryToBusinesses(operatorID);
	}

}
