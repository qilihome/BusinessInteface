package com.weichat.boss.action.vote;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import net.i314.web.util.ValidateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteExample;
import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;
import com.weichat.boss.service.vote.VoteOptionService;
import com.weichat.boss.service.vote.VoteService;

public class VoteAction extends BaseAction
{
	private static final long serialVersionUID = 3549782108526337880L;
	private static final Logger logger = Logger.getLogger(VoteAction.class);

	@Autowired
	private VoteService voteService;
	@Autowired
	private VoteOptionService voteOptionService;

	private int tId;
	private String cId;
	// 删除
	private String ids;

	private List<Vote> voteList;
	private Vote voteForm;
	private Vote vote;

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

			VoteExample example = new VoteExample();
			example.setDistinct(true);
			example.setOrderByClause("id asc");
			example.createCriteria().andCustomeridEqualTo(cId);

			voteList = voteService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询投票列表异常", e);
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
			voteForm.setCustomerid(getAttributeFromSession("cId").toString());
			voteForm.setTemplateid(Integer.parseInt(getAttributeFromSession("tId").toString()));
			voteService.insertSelective(voteForm);
			message = "添加投票成功";
			return list();
		} catch (Exception e)
		{
			logger.info("添加投票时发生异常，原因：" + e);
			message = "添加投票失败";
			return ERROR;
		}
	}

	public String editInit()
	{
		try
		{
			vote = voteService.selectByPrimaryKey(voteForm.getId());
			return EDIT;
		} catch (Exception e)
		{
			return ERROR;
		}
	}

	// 异步获取投票数据
	public void getCustomerVote()
	{
		JSONObject json = new JSONObject();
		try
		{
			vote = voteService.selectByPrimaryKey(voteForm.getId());
			if (null != vote)
			{
				VoteOptionExample voteOptionExample = new VoteOptionExample();
				voteOptionExample.setDistinct(true);
				voteOptionExample.setOrderByClause("votes desc");
				voteOptionExample.createCriteria().andVoteidEqualTo(vote.getId());
				List<VoteOption> optionList = voteOptionService.selectByExample(voteOptionExample);
				if (!ValidateUtil.isEmpty(optionList))
				{
					int totalRateNum = 0;
					for (VoteOption evo : optionList)
					{
						totalRateNum += evo.getVotes();
					}
					JSONArray options = new JSONArray();
					for (VoteOption evo : optionList)
					{
						if (totalRateNum > 0 && evo.getVotes() > 0)
							evo.setBackup1(new BigDecimal((evo.getVotes() / totalRateNum) * 100).setScale(0, RoundingMode.HALF_UP)
									.toString());
						else
							evo.setBackup1("0");
						
						JSONObject eachOption = new JSONObject();
						eachOption.put("id", evo.getId());
						eachOption.put("name", evo.getName());
						eachOption.put("voteNums", evo.getVotes());
						eachOption.put("voteRate", evo.getBackup1()+"%");
						options.add(eachOption);
					}
					vote.setOptionList(optionList);
					json.put("result", true);
					json.put("id", vote.getId());
					json.put("name", vote.getName());
					json.put("options", options);
					logger.info(json.toString());
				}else{
					json.put("result", false);
				}
			}
		} catch (Exception e)
		{
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

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	public List<Vote> getVoteList()
	{
		return voteList;
	}

	public void setVoteList(List<Vote> voteList)
	{
		this.voteList = voteList;
	}

	public Vote getVoteForm()
	{
		return voteForm;
	}

	public void setVoteForm(Vote voteForm)
	{
		this.voteForm = voteForm;
	}

	public Vote getVote()
	{
		return vote;
	}

	public void setVote(Vote vote)
	{
		this.vote = vote;
	}

	public String edit()
	{
		try
		{
			voteService.updateByPrimaryKeySelective(voteForm);
			message = "修改投票成功";
			return list();
		} catch (Exception e)
		{
			logger.info("修改投票时发生异常，原因：" + e);
			message = "修改投票失败";
			return ERROR;
		}
	}

	/**
	 * 删除投票
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
						voteService.deleteByPrimaryKey(Integer.valueOf(id));
					}
				}
				message = "删除投票成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除投票异常", e);
			message = "删除投票失败！";
			return ERROR;
		}
	}
}
