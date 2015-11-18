/**
 * 
 */
package com.weichat.boss.action.channel;

import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Channel;
import com.weichat.boss.data.pojo.ChannelExample;
import com.weichat.boss.service.channel.ChannelService;

/**
 * 频道管理
 * 
 * @author yinxianwen
 * 
 */
public class ChannelAction extends BaseAction
{
	private static final long serialVersionUID = -1676937881608823604L;
	private static final Logger logger = Logger.getLogger(ChannelAction.class);

	@Autowired
	private ChannelService channelService;

	// 查询
	private int customerId;
	private List<Channel> channelList;

	// 添加
	private Channel channelForm;

	// 修改
	private Channel channel;

	// 删除
	private String ids;

	public String list()
	{
		try
		{
			ChannelExample example = new ChannelExample();
			example.setDistinct(true);
			example.setOrderByClause("name asc");
			example.createCriteria().andCustomeridEqualTo(customerId);
			channelList = channelService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询频道列表异常", e);
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
			logger.error("初始化添加频道异常", e);
			return ERROR;
		}
	}

	public String add()
	{
		try
		{
			channelForm.setCustomerid(customerId);
			channelForm.setCreatetime(DateTimeUtil.getDateTimeString());
			channelService.insertSelective(channelForm);
			message = "添加频道成功！";
			return list();
		} catch (Exception e)
		{
			logger.error("添加频道添加异常", e);
			message = "添加频道失败！";
			return ERROR;
		}
	}

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
						channelService.deleteByPrimaryKey(Integer.parseInt(id));
					}
				}
				message = "删除频道成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除用户咨询异常", e);
			message = "删除频道失败！";
			return ERROR;
		}
	}

	public List<Channel> getChannelList()
	{
		return channelList;
	}

	public void setChannelList(List<Channel> channelList)
	{
		this.channelList = channelList;
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public Channel getChannel()
	{
		return channel;
	}

	public void setChannel(Channel channel)
	{
		this.channel = channel;
	}

	public Channel getChannelForm()
	{
		return channelForm;
	}

	public void setChannelForm(Channel channelForm)
	{
		this.channelForm = channelForm;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}
}
