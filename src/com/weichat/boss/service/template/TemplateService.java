package com.weichat.boss.service.template;

import java.util.List;

import com.weichat.boss.data.pojo.Template;
import com.weichat.boss.data.pojo.TemplateExample;

public interface TemplateService
{
	int countByExample(TemplateExample example);

	int deleteByExample(TemplateExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Template record);

	int insertSelective(Template record);

	List<Template> selectByExample(TemplateExample example);

	Template selectByPrimaryKey(Integer id);

	int updateByExampleSelective(Template record, TemplateExample example);

	int updateByExample(Template record, TemplateExample example);

	int updateByPrimaryKeySelective(Template record);

	int updateByPrimaryKey(Template record);
}
