package com.weichat.boss.action.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.core.base.Constant;
import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;
import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.data.pojo.ExpertReview;
import com.weichat.boss.data.pojo.ExpertReviewExample;
import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteExample;
import com.weichat.boss.service.album.CustomerAlbumService;
import com.weichat.boss.service.expertreview.ExpertReviewService;
import com.weichat.boss.service.templatearea.TemplateAreaService;
import com.weichat.boss.service.templatecontent.CustomerTemplateContentService;
import com.weichat.boss.service.vote.VoteService;

public class TemplateAreaAction extends BaseAction
{
	private static final long serialVersionUID = -3649377545529248529L;

	private static final int TYPE_ADD = 1;
	private static final int TYPE_UPDATE = 2;

	@Autowired
	private CustomerTemplateContentService customerTemplateContentService;
	@Autowired
	private TemplateAreaService templateAreaService;
	@Autowired
	private CustomerAlbumService customerAlbumService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private ExpertReviewService expertReviewService;

	// 获取区域对应的页面组件
	private int areaId;
	private int type;
	private int contentType;
	private String contentTypeName;
	private CustomerTemplateContent customerTemplateContent;
	// 相集列表
	private List<CustomerAlbum> albumList;
	// 投票列表
	private List<Vote> voteList;
	// 专家点评列表
	private List<ExpertReview> reviewList;

	/**
	 * 根据模板区域内容类型加载不同的模板组件
	 * 
	 * @return
	 */
	public String loadTemplatePlugin()
	{
		if (type == TYPE_ADD)
		{
			TemplateArea area = templateAreaService.selectByPrimaryKey(areaId);
			customerTemplateContent = new CustomerTemplateContent();
			customerTemplateContent.setTemplateId(area.getTemplateId());
			customerTemplateContent.setTemplateAreaId(area.getId());
			customerTemplateContent.setTemplateAreaName(area.getName());
			customerTemplateContent.setContenttype(area.getContenttype());
		} else if (TYPE_UPDATE == type)
		{
			customerTemplateContent = customerTemplateContentService.selectByPrimaryKey(areaId);
		}
		if (null != customerTemplateContent)
		{
			setContentType(customerTemplateContent.getContenttype());
			setContentTypeName(Constant.TEMPLATE_AREA_CONTENT_TYPE_NAME[customerTemplateContent.getContenttype()]);

			// 特殊模板处理
			if (Constant.CONTENT_TYPE_ALBUMS == customerTemplateContent.getContenttype())
			{
				// 相集模板
				CustomerAlbumExample albumExample = new CustomerAlbumExample();
				albumExample.setDistinct(true);
				albumExample.setOrderByClause("createTime asc");
				albumExample.createCriteria().andCustomeridEqualTo(getAttributeFromSession("cId").toString());
				albumList = customerAlbumService.selectByExample(albumExample);
			} else if (Constant.CONTENT_TYPE_VOTE == customerTemplateContent.getContenttype())
			{
				// 投票模板
				VoteExample example = new VoteExample();
				example.setDistinct(true);
				example.setOrderByClause("id asc");
				example.createCriteria().andCustomeridEqualTo(getAttributeFromSession("cId").toString());
				voteList = voteService.selectByExample(example);
			} else if (Constant.CONTENT_TYPE_REVIEW == customerTemplateContent.getContenttype())
			{
				// 专家点评模板
				ExpertReviewExample example = new ExpertReviewExample();
				example.setDistinct(true);
				example.setOrderByClause("id asc");
				example.createCriteria().andCustomeridEqualTo(getAttributeFromSession("cId").toString());
				reviewList = expertReviewService.selectByExample(example);
			}
		}
		return "plugin";
	}

	public int getAreaId()
	{
		return areaId;
	}

	public void setAreaId(int areaId)
	{
		this.areaId = areaId;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getContentTypeName()
	{
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName)
	{
		this.contentTypeName = contentTypeName;
	}

	public CustomerTemplateContent getCustomerTemplateContent()
	{
		return customerTemplateContent;
	}

	public void setCustomerTemplateContent(CustomerTemplateContent customerTemplateContent)
	{
		this.customerTemplateContent = customerTemplateContent;
	}

	public int getContentType()
	{
		return contentType;
	}

	public void setContentType(int contentType)
	{
		this.contentType = contentType;
	}

	public List<CustomerAlbum> getAlbumList()
	{
		return albumList;
	}

	public void setAlbumList(List<CustomerAlbum> albumList)
	{
		this.albumList = albumList;
	}

	public List<Vote> getVoteList()
	{
		return voteList;
	}

	public void setVoteList(List<Vote> voteList)
	{
		this.voteList = voteList;
	}

	public List<ExpertReview> getReviewList()
	{
		return reviewList;
	}

	public void setReviewList(List<ExpertReview> reviewList)
	{
		this.reviewList = reviewList;
	}

}
