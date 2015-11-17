package com.weichat.boss.action.album;

import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;
import com.weichat.boss.service.album.CustomerAlbumService;
import com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService;

/**
 * 相集管理
 * 
 * @author yinxianwen
 * 
 */
public class AlbumAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(AlbumAction.class);

	@Autowired
	private CustomerAlbumService customerAlbumService;
	@Autowired
	private CustomerAlbumPhotoService customerAlbumPhotoService;

	private int tId;
	private String cId;
	private CustomerAlbum customerAlbum;
	// 删除
	private String ids;

	// 相集列表
	private List<CustomerAlbum> albumList;

	/**
	 * 相集列表
	 * 
	 * @return
	 */
	public String list()
	{
		try
		{
			if (ValidateUtil.isEmpty(cId))
			{
				cId = getAttributeFromSession("cId") == null ? null : getAttributeFromSession("cId").toString();
				if (ValidateUtil.isEmpty(cId))
					return LIST;
			}

			setAttributeToSession("tName", "album");

			CustomerAlbumExample example = new CustomerAlbumExample();
			example.setDistinct(true);
			example.setOrderByClause("createTime asc");
			example.createCriteria().andCustomeridEqualTo(cId);

			albumList = customerAlbumService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询相集列表异常", e);
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
			customerAlbum.setCustomerid(getAttributeFromSession("cId").toString());
			customerAlbum.setCreatetime(DateTimeUtil.getDateTimeString());
			customerAlbumService.insertSelective(customerAlbum);
			message = "添加相集成功";
			return list();
		} catch (Exception e)
		{
			logger.info("添加相集时发生异常，原因：" + e);
			message = "添加相集失败";
			return ERROR;
		}
	}

	/**
	 * 删除相集
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
						int delResult = customerAlbumService.deleteByPrimaryKey(Integer.valueOf(id));
						if (delResult > 0)
						{
							CustomerAlbumPhotoExample example = new CustomerAlbumPhotoExample();
							example.createCriteria().andAlbumidEqualTo(Integer.valueOf(id));
							customerAlbumPhotoService.deleteByExample(example);
						}
					}
				}
				message = "删除相集成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除相集异常", e);
			message = "删除相集失败！";
			return ERROR;
		}
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}

	public List<CustomerAlbum> getAlbumList()
	{
		return albumList;
	}

	public void setAlbumList(List<CustomerAlbum> albumList)
	{
		this.albumList = albumList;
	}

	public String getCId()
	{
		return cId;
	}

	public void setCId(String id)
	{
		cId = id;
	}

	public CustomerAlbum getCustomerAlbum()
	{
		return customerAlbum;
	}

	public void setCustomerAlbum(CustomerAlbum customerAlbum)
	{
		this.customerAlbum = customerAlbum;
	}

	public int getTId()
	{
		return tId;
	}

	public void setTId(int id)
	{
		tId = id;
	}
}
