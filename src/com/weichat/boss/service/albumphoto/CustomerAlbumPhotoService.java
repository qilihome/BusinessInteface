/**
 * 
 */
package com.weichat.boss.service.albumphoto;

import java.util.List;

import com.weichat.boss.data.pojo.CustomerAlbumPhoto;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;

/**
 * 相集中的图片
 * 
 * @author yinxianwen
 * 
 */
public interface CustomerAlbumPhotoService
{
	int countByExample(CustomerAlbumPhotoExample example);

	int deleteByExample(CustomerAlbumPhotoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CustomerAlbumPhoto record);

	int insertSelective(CustomerAlbumPhoto record);

	List<CustomerAlbumPhoto> selectByExample(CustomerAlbumPhotoExample example);

	CustomerAlbumPhoto selectByPrimaryKey(Integer id);

	int updateByExampleSelective(CustomerAlbumPhoto record, CustomerAlbumPhotoExample example);

	int updateByExample(CustomerAlbumPhoto record, CustomerAlbumPhotoExample example);

	int updateByPrimaryKeySelective(CustomerAlbumPhoto record);

	int updateByPrimaryKey(CustomerAlbumPhoto record);
}
