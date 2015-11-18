package com.weichat.boss.service.templatearea;

import java.util.List;

import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.TemplateAreaExample;

public interface TemplateAreaService
{
	int countByExample(TemplateAreaExample example);

	int deleteByExample(TemplateAreaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TemplateArea record);

	int insertSelective(TemplateArea record);

	List<TemplateArea> selectByExample(TemplateAreaExample example);

	TemplateArea selectByPrimaryKey(Integer id);

	int updateByExampleSelective(TemplateArea record, TemplateAreaExample example);

	int updateByExample(TemplateArea record, TemplateAreaExample example);

	int updateByPrimaryKeySelective(TemplateArea record);

	int updateByPrimaryKey(TemplateArea record);
}
