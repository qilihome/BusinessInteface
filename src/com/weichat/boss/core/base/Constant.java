/*
 * 版权所有 (C) 2001-2010 深圳市艾派应用系统有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、Jan 28, 2010，Administrator创建。 
 */
package com.weichat.boss.core.base;

public interface Constant
{
	/* 模板中的内容类型 */
	public final static int CONTENT_TYPE_TEXT = 1;
	public final static int CONTENT_TYPE_IMAGE = 2;
	public final static int CONTENT_TYPE_VIDEO = 3;
	public final static int CONTENT_TYPE_MAP = 4;
	public final static int CONTENT_TYPE_PHOTOS = 5;
	public final static int CONTENT_TYPE_ALBUMS = 6;
	public final static int CONTENT_TYPE_VOTE = 7;
	public final static int CONTENT_TYPE_REVIEW = 8;
	public final static String[] TEMPLATE_AREA_CONTENT_TYPE_NAME = { "", "文本", "图片", "视频", "地图", "相册", "相集", "投票", "点评" };

	/* 模板相关 */
	//模板类型，根据该类型生成不同的资源文件
	public final static String TEMPLATE_TYPE_HTML = "html";
	public final static String TEMPLATE_TYPE_JSON = "json";
	
	public final static String FILE_TEMPLATE_TEMP_PATH = "file_template_temp_path";
	//默认的相册模板名称，主要用于生成相集的时候，相集下的相片要自动生成一个相册的页面，但是由于没有关联，所以只能通过配置来处理
	public final static String DEFAULT_PHOTOS_TEMP_NAME = "default_photos_temp_name";
	
	/* 静态化相关 */
	public final static String STATIC_FILE_RESOURCE_PATH = "html";//静态化相关资源保存路径
	
	/* 本服务域名 */
	public final static String SERVER_DOMAIN_URL = "server_domain_url";
	
	/* 产品生成静态化页面后回调后台产品接口地址 */
	public final static String PRODUCT_GENERATE_CALLBACK_URL = "product_generate_callback_url";
	public final static String CALLBACK_SWITCH = "callback_switch";//回调开关，1表示回调，其他表示不回调

	/* 图片相关 */
	public final static String PIC_UPLOAD_SIZE = "pic_upload_size";
	public final static String PIC_UPLOAD_TYPES = "pic_upload_types";
	public final static String PIC_UPLOAD_EXTS = "pic_upload_exts";

	/* 视频相关 */
	public final static String VIDEO_UPLOAD_SIZE = "video_upload_size";
	public final static String VIDEO_UPLOAD_TYPES = "video_upload_types";
	public final static String VIDEO_UPLOAD_EXTS = "video_upload_exts";
}

