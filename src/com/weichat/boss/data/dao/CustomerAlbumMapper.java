package com.weichat.boss.data.dao;

import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerAlbumMapper {
    int countByExample(CustomerAlbumExample example);

    int deleteByExample(CustomerAlbumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerAlbum record);

    int insertSelective(CustomerAlbum record);

    List<CustomerAlbum> selectByExample(CustomerAlbumExample example);

    CustomerAlbum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerAlbum record, @Param("example") CustomerAlbumExample example);

    int updateByExample(@Param("record") CustomerAlbum record, @Param("example") CustomerAlbumExample example);

    int updateByPrimaryKeySelective(CustomerAlbum record);

    int updateByPrimaryKey(CustomerAlbum record);
}