package com.weichat.boss.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
