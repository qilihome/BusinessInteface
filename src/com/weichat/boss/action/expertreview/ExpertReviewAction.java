/**
 * 
 */
package com.weichat.boss.action.expertreview;

import java.util.List;

import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.ExpertReview;
import com.weichat.boss.data.pojo.ExpertReviewExample;
import com.weichat.boss.service.expertreview.ExpertReviewService;

/**
 * 
 * 
 * @author yinxianwen
 * 
 */
public class ExpertReviewAction extends BaseAction
{
	private static final long serialVersionUID = -426689264291229346L;
	private static final Logger logger = Logger.getLogger(ExpertReviewAction.class);

	@Autowired
	private ExpertReviewService expertReviewService;

	private int tId;
	private String cId;
	// 删除
	private String ids;

	private List<ExpertReview> reviewList;
	private ExpertReview expertReviewForm;
	private ExpertReview expertReview;

	public String list()
	{
		try
		{
			if (ValidateUtil.isEmpty(cId))
			{
				cId = getAttributeFromSession("cId") == null ? null : getAttributeFromSession("cId").toString();
			}
			if (tId == 0)
			{
				tId = getAttributeFromSession("tId") == null ? 0 : Integer.parseInt(getAttributeFromSession("tId").toString());
			}
			if (ValidateUtil.isEmpty(cId) || tId == 0)
				return LIST;

			setAttributeToSession("tName", "expertreview");

			ExpertReviewExample example = new ExpertReviewExample();
			example.setDistinct(true);
			example.setOrderByClause("id asc");
			example.createCriteria().andCustomeridEqualTo(cId);

			reviewList = expertReviewService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询专家点评列表异常", e);
			return ERROR;
		}
	}

	public String addInit()
	{
		try
		{
			return ADD;
		} catch (Exception e)
		{
			return ERROR;
		}
	}

	public String add()
	{
		try
		{
			expertReviewForm.setCustomerid(getAttributeFromSession("cId").toString());
			expertReviewForm.setTemplateid(Integer.parseInt(getAttributeFromSession("tId").toString()));
			expertReviewService.insertSelective(expertReviewForm);
			message = "添加专家点评成功";
			return list();
		} catch (Exception e)
		{
			logger.info("添加专家点评时发生异常，原因：" + e);
			message = "添加专家点评失败";
			return ERROR;
		}
	}

	public String editInit()
	{
		try
		{
			expertReview = expertReviewService.selectByPrimaryKey(expertReviewForm.getId());
			return EDIT;
		} catch (Exception e)
		{
			return ERROR;
		}
	}

	public String edit()
	{
		try
		{
			expertReviewService.updateByPrimaryKeySelective(expertReviewForm);
			message = "修改专家点评成功";
			return list();
		} catch (Exception e)
		{
			logger.info("修改专家点评时发生异常，原因：" + e);
			message = "修改专家点评失败";
			return ERROR;
		}
	}

	/**
	 * 删除专家点评
	 * 
	 * @return
	 */
	public String batchDelete()
	{
		try
		{
			if (!ValidateUtil.isEmpty(ids))
			{
				String[] delIds = ids.split(",");
				for (String id : delIds)
				{
					if (id != null)
					{
						expertReviewService.deleteByPrimaryKey(Integer.valueOf(id));
					}
				}
				message = "删除专家点评成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除专家点评异常", e);
			message = "删除专家点评失败！";
			return ERROR;
		}
	}

	public int getTId()
	{
		return tId;
	}

	public void setTId(int id)
	{
		tId = id;
	}

	public String getCId()
	{
		return cId;
	}

	public void setCId(String id)
	{
		cId = id;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	public List<ExpertReview> getReviewList()
	{
		return reviewList;
	}

	public void setReviewList(List<ExpertReview> reviewList)
	{
		this.reviewList = reviewList;
	}

	public ExpertReview getExpertReviewForm()
	{
		return expertReviewForm;
	}

	public void setExpertReviewForm(ExpertReview expertReviewForm)
	{
		this.expertReviewForm = expertReviewForm;
	}

	public ExpertReview getExpertReview()
	{
		return expertReview;
	}

	public void setExpertReview(ExpertReview expertReview)
	{
		this.expertReview = expertReview;
	}
}
