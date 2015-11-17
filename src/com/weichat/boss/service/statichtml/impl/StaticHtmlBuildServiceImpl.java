/**
 * 
 */
package com.weichat.boss.service.statichtml.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.weichat.boss.core.base.Constant;
import com.weichat.boss.core.base.StaticHtmlBuilder;
import com.weichat.boss.core.util.Config;
import com.weichat.boss.core.util.SystemParamsLoader;
import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.service.statichtml.StaticHtmlBuildService;

@Service("staticHtmlBuildService")
public class StaticHtmlBuildServiceImpl implements StaticHtmlBuildService
{
	private static final Logger logger = Logger.getLogger(StaticHtmlBuildServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.statichtml.StaticHtmlBuildService#buildProductStaticHtml(java.lang.String,
	 *      java.lang.String, java.util.List)
	 */
	@Override
	public String buildProductStaticHtml(String customerId, String templateName, List<CustomerTemplateContent> customerTemplateContentList)
	{
		logger.info(String.format("开始生成静态页面，客户编号【%s】，模板名称【%s】", customerId, templateName));
		String staticHtmlPath = null;
		try
		{
			Map<String, Object> rootData = new HashMap<String, Object>();
			rootData.put("customerTemplateContentList", customerTemplateContentList);
			rootData.put("domain", Config.getProperty(Constant.SERVER_DOMAIN_URL));

			String staticHtmlPageRelaPath = Constant.STATIC_FILE_RESOURCE_PATH.concat(File.separator).concat(customerId).concat(
					File.separator).concat(templateName);
			String staticHtmlPageAbsPath = SystemParamsLoader.getRealPath(staticHtmlPageRelaPath);
			String ftlTemplateFileAbsPath = SystemParamsLoader.getRealPath("freemarker");
			String staticHtmlPageEncoding = "UTF-8";
			boolean buildResult = StaticHtmlBuilder.buildStaticHtmlPage(rootData, staticHtmlPageAbsPath, ftlTemplateFileAbsPath,
					templateName, staticHtmlPageEncoding);
			if (buildResult)
			{
				// http://localhost:8080/weichat/html/${customerId}/${photoTemplateName}/${photoTemplateName}.html
				staticHtmlPath = Config.getPathProperty(Constant.SERVER_DOMAIN_URL) + File.separator
						+ staticHtmlPageRelaPath.concat(File.separator) + templateName.concat(".html");
			}
		} catch (Exception e)
		{
			logger.info(String.format("生成静态页面，客户编号【%s】，模板名称【%s】，发生异常，原因：", customerId, templateName), e);
		}
		logger.info(String.format("结束生成静态页面，客户编号【%s】，模板名称【%s】。", customerId, templateName));
		return staticHtmlPath;
	}

	@Override
	public String buildAlbumPhotoStaticHtml(String customerId, int albumId, String albumTemplateName, String photoTemplateName,
			List<CustomerTemplateContent> customerTemplateContentList, String parentUrl)
	{
		logger.info(String.format("开始生成静态页面，客户编号【%s】，模板名称【%s】", customerId, photoTemplateName));
		String staticHtmlPath = null;
		try
		{
			Map<String, Object> rootData = new HashMap<String, Object>();
			rootData.put("customerTemplateContentList", customerTemplateContentList);
			rootData.put("domain", Config.getProperty(Constant.SERVER_DOMAIN_URL));
			rootData.put("parentUrl", parentUrl);
			String staticHtmlPageRelaPath = Constant.STATIC_FILE_RESOURCE_PATH.concat(File.separator).concat(customerId).concat(
					File.separator).concat(albumTemplateName).concat(File.separator).concat(photoTemplateName).concat(File.separator)
					.concat(String.valueOf(albumId));
			String staticHtmlPageAbsPath = SystemParamsLoader.getRealPath(staticHtmlPageRelaPath);
			String ftlTemplateFileAbsPath = SystemParamsLoader.getRealPath("freemarker");
			String staticHtmlPageEncoding = "UTF-8";
			boolean buildResult = StaticHtmlBuilder.buildStaticHtmlPage(rootData, staticHtmlPageAbsPath, ftlTemplateFileAbsPath,
					photoTemplateName, staticHtmlPageEncoding);
			if (buildResult)
			{
				// http://localhost:8080/weichat/html/${customerId}/${photoTemplateName}/${photoTemplateName}.html
				staticHtmlPath = Config.getPathProperty(Constant.SERVER_DOMAIN_URL) + File.separator
						+ staticHtmlPageRelaPath.concat(File.separator) + photoTemplateName.concat(".html");
			}
		} catch (Exception e)
		{
			logger.info(String.format("生成静态页面，客户编号【%s】，模板名称【%s】，发生异常，原因：", customerId, photoTemplateName), e);
		}
		logger.info(String.format("结束生成静态页面，客户编号【%s】，模板名称【%s】。", customerId, photoTemplateName));
		return staticHtmlPath;
	}
}
