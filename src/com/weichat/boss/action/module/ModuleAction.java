/**
 * 
 */
package com.weichat.boss.action.module;

import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Module;
import com.weichat.boss.data.pojo.ModuleExample;
import com.weichat.boss.service.module.ModuleService;

/**
 * 模块管理
 * 
 * @author yinxianwen
 * 
 */
public class ModuleAction extends BaseAction
{
	private static final long serialVersionUID = -1676937881608823604L;
	private static final Logger logger = Logger.getLogger(ModuleAction.class);

	@Autowired
	private ModuleService moduleService;

	// 查询
	private int customerId;
	private int channelId;
	private List<Module> moduleList;

	// 添加
	private Module moduleForm;

	// 修改
	private Module module;

	// 删除
	private String ids;

	public String list()
	{
		try
		{
			ModuleExample example = new ModuleExample();
			example.setDistinct(true);
			example.setOrderByClause("name asc");
			example.createCriteria().andCustomeridEqualTo(customerId).andChannelidEqualTo(channelId);
			moduleList = moduleService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询模块列表异常", e);
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
			logger.error("初始化添加模块异常", e);
			return ERROR;
		}
	}

	public String add()
	{
		try
		{
			moduleForm.setCustomerid(customerId);
			moduleForm.setChannelid(channelId);
			moduleForm.setCreatetime(DateTimeUtil.getDateTimeString());
			moduleService.insertSelective(moduleForm);
			message = "添加模块成功！";
			return list();
		} catch (Exception e)
		{
			logger.error("添加模块添加异常", e);
			message = "添加模块失败！";
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
						moduleService.deleteByPrimaryKey(Integer.parseInt(id));
					}
				}
				message = "删除模块成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除模块异常", e);
			message = "删除模块失败！";
			return ERROR;
		}
	}

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public int getChannelId()
	{
		return channelId;
	}

	public void setChannelId(int channelId)
	{
		this.channelId = channelId;
	}

	public List<Module> getModuleList()
	{
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList)
	{
		this.moduleList = moduleList;
	}

	public Module getModuleForm()
	{
		return moduleForm;
	}

	public void setModuleForm(Module moduleForm)
	{
		this.moduleForm = moduleForm;
	}

	public Module getModule()
	{
		return module;
	}

	public void setModule(Module module)
	{
		this.module = module;
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
