package com.weichat.boss.data.pojo;

import java.util.List;

import net.i314.web.util.ValidateUtil;

public class CustomerAlbum {
	//相集下的相片列表 
	private List<CustomerAlbumPhoto> photoList;
	//相集下的相片数量
	private int photoNums;
	//相集下的相册静态页面生成路径
	private String albumPhotoStaticHtml;

    public String getAlbumPhotoStaticHtml()
	{
		return albumPhotoStaticHtml;
	}

	public void setAlbumPhotoStaticHtml(String albumPhotoStaticHtml)
	{
		this.albumPhotoStaticHtml = albumPhotoStaticHtml;
	}

	public int getPhotoNums()
	{
    	photoNums = ValidateUtil.isEmpty(photoList) ? 0 : photoList.size();
    	return photoNums;
	}

	public void setPhotoNums(int photoNums)
	{
		this.photoNums = photoNums;
	}
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.id
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.customerId
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String customerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.albumName
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String albumname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.albumSummary
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String albumsummary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.albumAuthor
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String albumauthor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.shootTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String shoottime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.shootAddress
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String shootaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.albumStyle
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String albumstyle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.savePath
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String savepath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.createTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.backup1
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String backup1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.backup2
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String backup2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.backup3
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String backup3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_album.backup4
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    private String backup4;

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.id
     *
     * @return the value of t_customer_album.id
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.id
     *
     * @param id the value for t_customer_album.id
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.customerId
     *
     * @return the value of t_customer_album.customerId
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.customerId
     *
     * @param customerid the value for t_customer_album.customerId
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.albumName
     *
     * @return the value of t_customer_album.albumName
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getAlbumname() {
        return albumname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.albumName
     *
     * @param albumname the value for t_customer_album.albumName
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setAlbumname(String albumname) {
        this.albumname = albumname == null ? null : albumname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.albumSummary
     *
     * @return the value of t_customer_album.albumSummary
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getAlbumsummary() {
        return albumsummary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.albumSummary
     *
     * @param albumsummary the value for t_customer_album.albumSummary
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setAlbumsummary(String albumsummary) {
        this.albumsummary = albumsummary == null ? null : albumsummary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.albumAuthor
     *
     * @return the value of t_customer_album.albumAuthor
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getAlbumauthor() {
        return albumauthor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.albumAuthor
     *
     * @param albumauthor the value for t_customer_album.albumAuthor
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setAlbumauthor(String albumauthor) {
        this.albumauthor = albumauthor == null ? null : albumauthor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.shootTime
     *
     * @return the value of t_customer_album.shootTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getShoottime() {
        return shoottime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.shootTime
     *
     * @param shoottime the value for t_customer_album.shootTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setShoottime(String shoottime) {
        this.shoottime = shoottime == null ? null : shoottime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.shootAddress
     *
     * @return the value of t_customer_album.shootAddress
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getShootaddress() {
        return shootaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.shootAddress
     *
     * @param shootaddress the value for t_customer_album.shootAddress
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setShootaddress(String shootaddress) {
        this.shootaddress = shootaddress == null ? null : shootaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.albumStyle
     *
     * @return the value of t_customer_album.albumStyle
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getAlbumstyle() {
        return albumstyle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.albumStyle
     *
     * @param albumstyle the value for t_customer_album.albumStyle
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setAlbumstyle(String albumstyle) {
        this.albumstyle = albumstyle == null ? null : albumstyle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.savePath
     *
     * @return the value of t_customer_album.savePath
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getSavepath() {
        return savepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.savePath
     *
     * @param savepath the value for t_customer_album.savePath
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setSavepath(String savepath) {
        this.savepath = savepath == null ? null : savepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.createTime
     *
     * @return the value of t_customer_album.createTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.createTime
     *
     * @param createtime the value for t_customer_album.createTime
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.backup1
     *
     * @return the value of t_customer_album.backup1
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getBackup1() {
        return backup1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.backup1
     *
     * @param backup1 the value for t_customer_album.backup1
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.backup2
     *
     * @return the value of t_customer_album.backup2
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getBackup2() {
        return backup2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.backup2
     *
     * @param backup2 the value for t_customer_album.backup2
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.backup3
     *
     * @return the value of t_customer_album.backup3
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getBackup3() {
        return backup3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.backup3
     *
     * @param backup3 the value for t_customer_album.backup3
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_album.backup4
     *
     * @return the value of t_customer_album.backup4
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public String getBackup4() {
        return backup4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_album.backup4
     *
     * @param backup4 the value for t_customer_album.backup4
     *
     * @mbggenerated Thu Jun 27 21:21:56 CST 2013
     */
    public void setBackup4(String backup4) {
        this.backup4 = backup4 == null ? null : backup4.trim();
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