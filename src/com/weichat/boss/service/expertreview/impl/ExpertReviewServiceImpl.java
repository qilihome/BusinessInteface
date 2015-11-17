package com.weichat.boss.service.expertreview.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.ExpertReviewMapper;
import com.weichat.boss.data.pojo.ExpertReview;
import com.weichat.boss.data.pojo.ExpertReviewExample;
import com.weichat.boss.service.expertreview.ExpertReviewService;

@Service("expertReviewService")
@Transactional
public class ExpertReviewServiceImpl implements ExpertReviewService
{
	@Autowired
	private ExpertReviewMapper expertReviewMapper;

	@Override
	public int countByExample(ExpertReviewExample example)
	{

		return expertReviewMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(ExpertReviewExample example)
	{

		return expertReviewMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return expertReviewMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ExpertReview record)
	{

		return expertReviewMapper.insert(record);
	}

	@Override
	public int insertSelective(ExpertReview record)
	{

		return expertReviewMapper.insertSelective(record);
	}

	@Override
	public List<ExpertReview> selectByExample(ExpertReviewExample example)
	{

		return expertReviewMapper.selectByExample(example);
	}

	@Override
	public ExpertReview selectByPrimaryKey(Integer id)
	{

		return expertReviewMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(ExpertReview record, ExpertReviewExample example)
	{

		return expertReviewMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(ExpertReview record, ExpertReviewExample example)
	{

		return expertReviewMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(ExpertReview record)
	{

		return expertReviewMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ExpertReview record)
	{

		return expertReviewMapper.updateByPrimaryKeySelective(record);
	}
}
