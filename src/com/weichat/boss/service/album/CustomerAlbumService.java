/**
 * 
 */
package com.weichat.boss.service.album;

import java.util.List;

import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;

/**
 * 相集
 * 
 * @author yinxianwen
 * 
 */
public interface CustomerAlbumService
{
	int countByExample(CustomerAlbumExample example);

	int deleteByExample(CustomerAlbumExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CustomerAlbum record);

	int insertSelective(CustomerAlbum record);

	List<CustomerAlbum> selectByExample(CustomerAlbumExample example);

	CustomerAlbum selectByPrimaryKey(Integer id);

	int updateByExampleSelective(CustomerAlbum record, CustomerAlbumExample example);

	int updateByExample(CustomerAlbum record, CustomerAlbumExample example);

	int updateByPrimaryKeySelective(CustomerAlbum record);

	int updateByPrimaryKey(CustomerAlbum record);
}
