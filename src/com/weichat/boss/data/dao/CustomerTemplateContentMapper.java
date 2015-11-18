package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.data.pojo.CustomerTemplateContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerTemplateContentMapper {
    int countByExample(CustomerTemplateContentExample example);

    int deleteByExample(CustomerTemplateContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerTemplateContent record);

    int insertSelective(CustomerTemplateContent record);

    List<CustomerTemplateContent> selectByExample(CustomerTemplateContentExample example);

    CustomerTemplateContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerTemplateContent record, @Param("example") CustomerTemplateContentExample example);

    int updateByExample(@Param("record") CustomerTemplateContent record, @Param("example") CustomerTemplateContentExample example);

    int updateByPrimaryKeySelective(CustomerTemplateContent record);

    int updateByPrimaryKey(CustomerTemplateContent record);
}