package com.weichat.boss.action.vote;

import java.util.List;

import net.i314.web.util.ValidateUtil;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;
import com.weichat.boss.service.vote.VoteOptionService;
import com.weichat.boss.service.vote.VoteService;

public class VoteOptionAction extends BaseAction
{
	private static final long serialVersionUID = 3549782108526337880L;
	private static final Logger logger = Logger.getLogger(VoteOptionAction.class);

	@Autowired
	private VoteOptionService voteOptionService;
	@Autowired
	private VoteService voteService;

	private int tId;
	private String cId;
	private int voteId;
	// 删除
	private String ids;

	private List<VoteOption> voteOptionList;
	private VoteOption voteOptionForm;
	private VoteOption voteOption;
	private Vote vote;

	public String list()
	{
		try
		{
			vote = voteService.selectByPrimaryKey(voteId);

			VoteOptionExample example = new VoteOptionExample();
			example.setDistinct(true);
			example.setOrderByClause("id asc");
			example.createCriteria().andVoteidEqualTo(voteId);

			voteOptionList = voteOptionService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询投票选项列表异常", e);
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
			voteId = voteOptionForm.getVoteid();
			voteOptionForm.setCustomerid(getAttributeFromSession("cId").toString());
			voteOptionForm.setTemplateid(Integer.parseInt(getAttributeFromSession("tId").toString()));
			voteOptionService.insertSelective(voteOptionForm);
			message = "添加投票选项成功";
			return list();
		} catch (Exception e)
		{
			logger.info("添加投票选项时发生异常，原因：" + e);
			message = "添加投票选项失败";
			return ERROR;
		}
	}

	public String editInit()
	{
		try
		{
			voteOption = voteOptionService.selectByPrimaryKey(voteOptionForm.getId());
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
			voteId = voteOptionForm.getVoteid();
			voteOptionService.updateByPrimaryKeySelective(voteOptionForm);
			message = "修改投票选项成功";
			return list();
		} catch (Exception e)
		{
			logger.info("修改投票选项时发生异常，原因：" + e);
			message = "修改投票选项失败";
			return ERROR;
		}
	}

	/**
	 * 删除投票选项
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
						voteOptionService.deleteByPrimaryKey(Integer.valueOf(id));
					}
				}
				message = "删除投票选项成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除投票选项异常", e);
			message = "删除投票选项失败！";
			return ERROR;
		}
	}

	public void addReviewRote()
	{
		JSONObject json = new JSONObject();
		try
		{
			int rateResult = voteOptionService.rateVoteOption(voteOptionForm.getId());
			if (rateResult > 0)
				json.put("result", true);
			else
				json.put("result", false);
		} catch (RuntimeException e)
		{
			e.printStackTrace();
			json.put("result", false);
		}
		writeJsonAjaxResponse(json.toString());
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

	public int getVoteId()
	{
		return voteId;
	}

	public void setVoteId(int voteId)
	{
		this.voteId = voteId;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	public List<VoteOption> getVoteOptionList()
	{
		return voteOptionList;
	}

	public void setVoteOptionList(List<VoteOption> voteOptionList)
	{
		this.voteOptionList = voteOptionList;
	}

	public VoteOption getVoteOptionForm()
	{
		return voteOptionForm;
	}

	public void setVoteOptionForm(VoteOption voteOptionForm)
	{
		this.voteOptionForm = voteOptionForm;
	}

	public VoteOption getVoteOption()
	{
		return voteOption;
	}

	public void setVoteOption(VoteOption voteOption)
	{
		this.voteOption = voteOption;
	}

	public Vote getVote()
	{
		return vote;
	}

	public void setVote(Vote vote)
	{
		this.vote = vote;
	}
}
