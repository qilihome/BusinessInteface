package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoteOptionMapper {
	int rateVoteOption(Integer id) ;
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int countByExample(VoteOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int deleteByExample(VoteOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int insert(VoteOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int insertSelective(VoteOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    List<VoteOption> selectByExample(VoteOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    VoteOption selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByExampleSelective(@Param("record") VoteOption record, @Param("example") VoteOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByExample(@Param("record") VoteOption record, @Param("example") VoteOptionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByPrimaryKeySelective(VoteOption record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_option
     *
     * @mbggenerated Tue Jul 02 21:21:17 CST 2013
     */
    int updateByPrimaryKey(VoteOption record);
}