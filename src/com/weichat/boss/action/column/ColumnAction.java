/**
 * 
 */
package com.weichat.boss.action.column;

import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.Column;
import com.weichat.boss.data.pojo.ColumnExample;
import com.weichat.boss.service.column.ColumnService;

/**
 * 栏目管理
 * 
 * @author yinxianwen
 * 
 */
public class ColumnAction extends BaseAction
{
	private static final long serialVersionUID = -1676937881608823604L;
	private static final Logger logger = Logger.getLogger(ColumnAction.class);

	@Autowired
	private ColumnService columnService;

	// 查询
	private int customerId;
	private int channelId;
	private int moduleId;
	private List<Column> columnList;

	// 添加
	private Column columnForm;

	// 修改
	private Column column;

	// 删除
	private String ids;

	public String list()
	{
		try
		{
			ColumnExample example = new ColumnExample();
			example.setDistinct(true);
			example.setOrderByClause("name asc");
			example.createCriteria().andCustomeridEqualTo(customerId).andChannelidEqualTo(channelId).andModuleidEqualTo(moduleId);
			columnList = columnService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询栏目列表异常", e);
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
			logger.error("初始化添加栏目异常", e);
			return ERROR;
		}
	}

	public String add()
	{
		try
		{
			columnForm.setCustomerid(customerId);
			columnForm.setChannelid(channelId);
			columnForm.setModuleid(moduleId);
			columnForm.setCreatetime(DateTimeUtil.getDateTimeString());
			columnService.insertSelective(columnForm);
			message = "添加栏目成功！";
			return list();
		} catch (Exception e)
		{
			logger.error("添加栏目添加异常", e);
			message = "添加栏目失败！";
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
						columnService.deleteByPrimaryKey(Integer.parseInt(id));
					}
				}
				message = "删除栏目成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除栏目异常", e);
			message = "删除栏目失败！";
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

	public int getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(int moduleId)
	{
		this.moduleId = moduleId;
	}

	public Column getColumnForm()
	{
		return columnForm;
	}

	public void setColumnForm(Column columnForm)
	{
		this.columnForm = columnForm;
	}

	public Column getColumn()
	{
		return column;
	}

	public void setColumn(Column column)
	{
		this.column = column;
	}

	public List<Column> getColumnList()
	{
		return columnList;
	}

	public void setColumnList(List<Column> columnList)
	{
		this.columnList = columnList;
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
