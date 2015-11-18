package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.TemplateAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplateAreaMapper {
    int countByExample(TemplateAreaExample example);

    int deleteByExample(TemplateAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TemplateArea record);

    int insertSelective(TemplateArea record);

    List<TemplateArea> selectByExample(TemplateAreaExample example);

    TemplateArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TemplateArea record, @Param("example") TemplateAreaExample example);

    int updateByExample(@Param("record") TemplateArea record, @Param("example") TemplateAreaExample example);

    int updateByPrimaryKeySelective(TemplateArea record);

    int updateByPrimaryKey(TemplateArea record);
}