/**
 * 
 */
package com.weichat.boss.service.expertreview;

import java.util.List;

import com.weichat.boss.data.pojo.ExpertReview;
import com.weichat.boss.data.pojo.ExpertReviewExample;

/**
 * 专家点评
 * 
 * @author yinxianwen
 * 
 */
public interface ExpertReviewService
{
	int countByExample(ExpertReviewExample example);

	int deleteByExample(ExpertReviewExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(ExpertReview record);

	int insertSelective(ExpertReview record);

	List<ExpertReview> selectByExample(ExpertReviewExample example);

	ExpertReview selectByPrimaryKey(Integer id);

	int updateByExampleSelective(ExpertReview record, ExpertReviewExample example);

	int updateByExample(ExpertReview record, ExpertReviewExample example);

	int updateByPrimaryKeySelective(ExpertReview record);

	int updateByPrimaryKey(ExpertReview record);
}
