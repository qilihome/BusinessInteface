package com.weichat.boss.data.pojo;

import java.util.List;

public class CustomerTemplateContent {
	// 相集列表
	private List<CustomerAlbum> albumList;
	//相集下的相片列表 
	private List<CustomerAlbumPhoto> photoList;
	// 投票活动
	private Vote vote;
	// 专家点评列表
	private List<ExpertReview> reviewList;
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.customer_Id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.template_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private Integer templateId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.template_area_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private Integer templateAreaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.template_area_name
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String templateAreaName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.title
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.content
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.summary
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String summary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.contentType
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private Integer contenttype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.backup1
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String backup1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.backup2
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String backup2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.backup3
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String backup3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer_template_content.backup4
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    private String backup4;

    public Vote getVote()
	{
		return vote;
	}

	public void setVote(Vote vote)
	{
		this.vote = vote;
	}

	public List<CustomerAlbum> getAlbumList()
	{
		return albumList;
	}

	public void setAlbumList(List<CustomerAlbum> albumList)
	{
		this.albumList = albumList;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.id
     *
     * @return the value of t_customer_template_content.id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.id
     *
     * @param id the value for t_customer_template_content.id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.customer_Id
     *
     * @return the value of t_customer_template_content.customer_Id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.customer_Id
     *
     * @param customerId the value for t_customer_template_content.customer_Id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.template_id
     *
     * @return the value of t_customer_template_content.template_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.template_id
     *
     * @param templateId the value for t_customer_template_content.template_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.template_area_id
     *
     * @return the value of t_customer_template_content.template_area_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public Integer getTemplateAreaId() {
        return templateAreaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.template_area_id
     *
     * @param templateAreaId the value for t_customer_template_content.template_area_id
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setTemplateAreaId(Integer templateAreaId) {
        this.templateAreaId = templateAreaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.template_area_name
     *
     * @return the value of t_customer_template_content.template_area_name
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getTemplateAreaName() {
        return templateAreaName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.template_area_name
     *
     * @param templateAreaName the value for t_customer_template_content.template_area_name
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setTemplateAreaName(String templateAreaName) {
        this.templateAreaName = templateAreaName == null ? null : templateAreaName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.title
     *
     * @return the value of t_customer_template_content.title
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.title
     *
     * @param title the value for t_customer_template_content.title
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.content
     *
     * @return the value of t_customer_template_content.content
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.content
     *
     * @param content the value for t_customer_template_content.content
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.summary
     *
     * @return the value of t_customer_template_content.summary
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.summary
     *
     * @param summary the value for t_customer_template_content.summary
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.contentType
     *
     * @return the value of t_customer_template_content.contentType
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public Integer getContenttype() {
        return contenttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.contentType
     *
     * @param contenttype the value for t_customer_template_content.contentType
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setContenttype(Integer contenttype) {
        this.contenttype = contenttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.backup1
     *
     * @return the value of t_customer_template_content.backup1
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getBackup1() {
        return backup1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.backup1
     *
     * @param backup1 the value for t_customer_template_content.backup1
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.backup2
     *
     * @return the value of t_customer_template_content.backup2
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getBackup2() {
        return backup2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.backup2
     *
     * @param backup2 the value for t_customer_template_content.backup2
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setBackup2(String backup2) {
        this.backup2 = backup2 == null ? null : backup2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.backup3
     *
     * @return the value of t_customer_template_content.backup3
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getBackup3() {
        return backup3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.backup3
     *
     * @param backup3 the value for t_customer_template_content.backup3
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public void setBackup3(String backup3) {
        this.backup3 = backup3 == null ? null : backup3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer_template_content.backup4
     *
     * @return the value of t_customer_template_content.backup4
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
     */
    public String getBackup4() {
        return backup4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer_template_content.backup4
     *
     * @param backup4 the value for t_customer_template_content.backup4
     *
     * @mbggenerated Sat Jun 22 17:52:00 CST 2013
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

	public List<ExpertReview> getReviewList()
	{
		return reviewList;
	}

	public void setReviewList(List<ExpertReview> reviewList)
	{
		this.reviewList = reviewList;
	}
}