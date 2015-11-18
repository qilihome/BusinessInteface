package com.weichat.boss.core.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.weichat.boss.core.base.Constant;

/**
 * 系统级参数加载器
 */
public class SystemParamsLoader implements ServletContextListener
{
	private static ServletContext CONTEXT = null;

	public void contextDestroyed(ServletContextEvent sce)
	{

	}

	public void contextInitialized(ServletContextEvent sce)
	{
		CONTEXT = sce.getServletContext();
		/* 模板相关 */
		CONTEXT.setAttribute(Constant.FILE_TEMPLATE_TEMP_PATH, Config.getProperty(Constant.FILE_TEMPLATE_TEMP_PATH));
		/* 域名相关 */
		CONTEXT.setAttribute(Constant.SERVER_DOMAIN_URL, Config.getProperty(Constant.SERVER_DOMAIN_URL));
		/* 图片相关 */
		CONTEXT.setAttribute(Constant.PIC_UPLOAD_SIZE, Config.getProperty(Constant.PIC_UPLOAD_SIZE));
		CONTEXT.setAttribute(Constant.PIC_UPLOAD_TYPES, Config.getProperty(Constant.PIC_UPLOAD_TYPES));
		CONTEXT.setAttribute(Constant.PIC_UPLOAD_EXTS, Config.getProperty(Constant.PIC_UPLOAD_EXTS));

		/* 视频相关 */
		CONTEXT.setAttribute(Constant.VIDEO_UPLOAD_SIZE, Config.getProperty(Constant.VIDEO_UPLOAD_SIZE));
		CONTEXT.setAttribute(Constant.VIDEO_UPLOAD_TYPES, Config.getProperty(Constant.VIDEO_UPLOAD_TYPES));
		CONTEXT.setAttribute(Constant.VIDEO_UPLOAD_EXTS, Config.getProperty(Constant.VIDEO_UPLOAD_EXTS));
	}

	public static Object getObject(String key)
	{
		return CONTEXT.getAttribute(key);
	}

	public static String getRootPath()
	{
		return CONTEXT.getRealPath("");
	}

	public static String getString(String key)
	{
		return (String) getObject(key);
	}

	public static String getRealPath(String path)
	{
		return CONTEXT.getRealPath(path);
	}
}
