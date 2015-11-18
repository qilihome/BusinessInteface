/**
 * 
 */
package com.weichat.boss.action.albumphoto;

import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumPhoto;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;
import com.weichat.boss.service.album.CustomerAlbumService;
import com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService;

/**
 * 相集中的相片管理
 * 
 * @author yinxianwen
 * 
 */
public class AlbumphotoAction extends BaseAction
{
	private static final long serialVersionUID = -743816520451194422L;
	private static final Logger logger = Logger.getLogger(AlbumphotoAction.class);

	@Autowired
	private CustomerAlbumService customerAlbumService;
	@Autowired
	private CustomerAlbumPhotoService customerAlbumPhotoService;

	private String ids;
	private int albumId;
	private int uploadcount;//上传了多少张图片

	private CustomerAlbum album;
	private CustomerAlbumPhoto photoForm;
	private List<CustomerAlbumPhoto> photoList;

	public int getUploadcount()
	{
		return uploadcount;
	}

	public void setUploadcount(int uploadcount)
	{
		this.uploadcount = uploadcount;
	}

	public String list()
	{
		try
		{
			album = customerAlbumService.selectByPrimaryKey(albumId);

			CustomerAlbumPhotoExample example = new CustomerAlbumPhotoExample();
			example.setDistinct(true);
			example.setOrderByClause("id asc");
			example.createCriteria().andAlbumidEqualTo(albumId);
			photoList = customerAlbumPhotoService.selectByExample(example);
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
			album = customerAlbumService.selectByPrimaryKey(albumId);
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
			if (uploadcount > 0)
			{
				CustomerAlbumPhoto eachPhotoForm = new CustomerAlbumPhoto();
				eachPhotoForm.setAlbumid(albumId);
				eachPhotoForm.setCustomerid(getAttributeFromSession("cId").toString());
				eachPhotoForm.setCreatetime(DateTimeUtil.getDateTimeString());
				for (int i = 1; i <= uploadcount; i++)
				{
					eachPhotoForm.setSavefile(request.getParameter("photosrc_" + i));
					eachPhotoForm.setPhotoname(request.getParameter("photoname_" + i));
					eachPhotoForm.setPhotosummary(request.getParameter("photosummary_" + i));
					eachPhotoForm.setBackup1(request.getParameter("photosize_" + i));
					customerAlbumPhotoService.insertSelective(eachPhotoForm);
				}
			}
			message = "添加相片成功";
			return list();
		} catch (Exception e)
		{
			logger.info("添加相片时发生异常，原因：" + e);
			message = "添加相片失败";
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
						customerAlbumPhotoService.deleteByPrimaryKey(Integer.valueOf(id));
					}
				}
				message = "删除相片成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除相片异常", e);
			message = "删除相片失败！";
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

	public int getAlbumId()
	{
		return albumId;
	}

	public void setAlbumId(int albumId)
	{
		this.albumId = albumId;
	}

	public CustomerAlbum getAlbum()
	{
		return album;
	}

	public void setAlbum(CustomerAlbum album)
	{
		this.album = album;
	}

	public CustomerAlbumPhoto getPhotoForm()
	{
		return photoForm;
	}

	public void setPhotoForm(CustomerAlbumPhoto photoForm)
	{
		this.photoForm = photoForm;
	}

	public List<CustomerAlbumPhoto> getPhotoList()
	{
		return photoList;
	}

	public void setPhotoList(List<CustomerAlbumPhoto> photoList)
	{
		this.photoList = photoList;
	}
}
