package com.weichat.boss.service.statichtml;

import java.util.List;

import com.weichat.boss.data.pojo.CustomerTemplateContent;

/**
 * 负责静态化页面生成
 * 
 * @author yinxianwen
 * 
 */
public interface StaticHtmlBuildService
{
	/**
	 * 生成某个产品的静态化页面
	 * 
	 * @param customerId
	 * @param templateName
	 * @param customerTemplateContentList
	 * @return
	 */
	String buildProductStaticHtml(String customerId, String templateName, List<CustomerTemplateContent> customerTemplateContentList);

	/**
	 * 生成相集下面的相册的静态化页面
	 * 
	 * @param customerId
	 * @param albumId
	 * @param albumTemplateName
	 * @param photoTemplateName
	 * @param customerTemplateContentList
	 * @return
	 */
	String buildAlbumPhotoStaticHtml(String customerId, int albumId, String albumTemplateName, String photoTemplateName,
			List<CustomerTemplateContent> customerTemplateContentList, String parentUrl);
}
