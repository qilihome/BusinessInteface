package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.Template;
import com.weichat.boss.data.pojo.TemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int countByExample(TemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int deleteByExample(TemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int insert(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int insertSelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    List<Template> selectByExample(TemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    Template selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int updateByExampleSelective(@Param("record") Template record, @Param("example") TemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int updateByExample(@Param("record") Template record, @Param("example") TemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int updateByPrimaryKeySelective(Template record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_template
     *
     * @mbggenerated Sun Jun 30 15:04:54 CST 2013
     */
    int updateByPrimaryKey(Template record);
}