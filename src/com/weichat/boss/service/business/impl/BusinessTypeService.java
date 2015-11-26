package com.weichat.boss.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.BusinessTypeMapper;
import com.weichat.boss.data.pojo.BusinessType;
import com.weichat.boss.service.business.IBusinessTypeService;
@Service("businessTypeService")
@Transactional
public class BusinessTypeService implements IBusinessTypeService {

	@Autowired
	private BusinessTypeMapper businessTypeMapper;
	
	@Override
	public List<BusinessType> list() {
		// TODO Auto-generated method stub
		return businessTypeMapper.list();
	}

}
