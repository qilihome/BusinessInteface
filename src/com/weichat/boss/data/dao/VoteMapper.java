package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int countByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int deleteByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int insert(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int insertSelective(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    List<Vote> selectByExample(VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    Vote selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByExampleSelective(@Param("record") Vote record, @Param("example") VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByExample(@Param("record") Vote record, @Param("example") VoteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByPrimaryKeySelective(Vote record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByPrimaryKey(Vote record);
}