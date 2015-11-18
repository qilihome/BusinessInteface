package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.CustomerAlbumPhoto;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAlbumPhotoMapper {
    int countByExample(CustomerAlbumPhotoExample example);

    int deleteByExample(CustomerAlbumPhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerAlbumPhoto record);

    int insertSelective(CustomerAlbumPhoto record);

    List<CustomerAlbumPhoto> selectByExample(CustomerAlbumPhotoExample example);

    CustomerAlbumPhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerAlbumPhoto record, @Param("example") CustomerAlbumPhotoExample example);

    int updateByExample(@Param("record") CustomerAlbumPhoto record, @Param("example") CustomerAlbumPhotoExample example);

    int updateByPrimaryKeySelective(CustomerAlbumPhoto record);

    int updateByPrimaryKey(CustomerAlbumPhoto record);
}