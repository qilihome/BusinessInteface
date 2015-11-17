package com.weichat.boss.service.module;

import java.util.List;

import com.weichat.boss.data.pojo.Module;
import com.weichat.boss.data.pojo.ModuleExample;

public interface ModuleService
{
	int countByExample(ModuleExample example);

	int deleteByExample(ModuleExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Module record);

	int insertSelective(Module record);

	List<Module> selectByExample(ModuleExample example);

	Module selectByPrimaryKey(Integer id);

	int updateByExampleSelective(Module record, ModuleExample example);

	int updateByExample(Module record, ModuleExample example);

	int updateByPrimaryKeySelective(Module record);

	int updateByPrimaryKey(Module record);
}
