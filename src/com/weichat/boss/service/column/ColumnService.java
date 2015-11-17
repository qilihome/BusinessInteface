package com.weichat.boss.service.column;

import java.util.List;

import com.weichat.boss.data.pojo.Column;
import com.weichat.boss.data.pojo.ColumnExample;

public interface ColumnService
{
	int countByExample(ColumnExample example);

	int deleteByExample(ColumnExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Column record);

	int insertSelective(Column record);

	List<Column> selectByExample(ColumnExample example);

	Column selectByPrimaryKey(Integer id);

	int updateByExampleSelective(Column record, ColumnExample example);

	int updateByExample(Column record, ColumnExample example);

	int updateByPrimaryKeySelective(Column record);

	int updateByPrimaryKey(Column record);
}
