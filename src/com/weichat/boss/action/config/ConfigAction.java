package com.weichat.boss.action.config;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.i314.web.util.ValidateUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.core.base.Constant;
import com.weichat.boss.core.util.Config;
import com.weichat.boss.core.util.FileTool;
import com.weichat.boss.core.util.HttpTools;
import com.weichat.boss.core.util.SystemParamsLoader;
import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;
import com.weichat.boss.data.pojo.CustomerAlbumPhoto;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;
import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.data.pojo.CustomerTemplateContentExample;
import com.weichat.boss.data.pojo.ExpertReviewExample;
import com.weichat.boss.data.pojo.Template;
import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.TemplateAreaExample;
import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;
import com.weichat.boss.service.album.CustomerAlbumService;
import com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService;
import com.weichat.boss.service.expertreview.ExpertReviewService;
import com.weichat.boss.service.statichtml.StaticHtmlBuildService;
import com.weichat.boss.service.template.TemplateService;
import com.weichat.boss.service.templatearea.TemplateAreaService;
import com.weichat.boss.service.templatecontent.CustomerTemplateContentService;
import com.weichat.boss.service.vote.VoteOptionService;
import com.weichat.boss.service.vote.VoteService;

/**
 * 提供给BOSS端链接过来做页面配置
 * 
 * @author yinxianwen
 * 
 */
public class ConfigAction extends BaseAction
{
	private static final long serialVersionUID = 6823672612334766363L;
	private static final Logger logger = Logger.getLogger(ConfigAction.class);

	@Autowired
	private TemplateService templateService;
	@Autowired
	private TemplateAreaService templateAreaService;
	@Autowired
	private CustomerTemplateContentService CustomerTemplateContentService;
	@Autowired
	private StaticHtmlBuildService staticHtmlBuildService;
	@Autowired
	private CustomerAlbumService customerAlbumService;
	@Autowired
	private CustomerAlbumPhotoService customerAlbumPhotoService;
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoteOptionService voteOptionService;
	@Autowired
	private ExpertReviewService expertReviewService;

	// 配置条件，从BOSS传递过来
	private String cId;
	private int tId;
	private String pId;
	private String tName;

	// 保存配置
	private String areaIds;
	private String staticHtmlPath;

	private List<CustomerTemplateContent> customerTemplateContentList;
	private List<TemplateArea> templateAreaList;

	public String getPId()
	{
		return pId;
	}

	public void setPId(String id)
	{
		pId = id;
	}

	/**
	 * 开放给后台BOSS进行页面配置的接口Servlet
	 * 
	 * @return
	 */
	public String configInit()
	{
		if (tId == 0)
			tId = Integer.parseInt(getAttributeFromSession("tId").toString());

		if (ValidateUtil.isEmpty(cId))
			cId = getAttributeFromSession("cId").toString();

		if (ValidateUtil.isEmpty(pId))
			pId = getAttributeFromSession("pId").toString();

		if (tId == 0 || ValidateUtil.isEmpty(cId) || ValidateUtil.isEmpty(pId))
			return "config";

		setAttributeToSession("tId", tId);
		setAttributeToSession("cId", cId);
		setAttributeToSession("pId", pId);
		try
		{
			Template template = templateService.selectByPrimaryKey(tId);
			if (null != template)
			{
				tName = template.getName();
				setAttributeToSession("tName", tName);

				CustomerTemplateContentExample cexample = new CustomerTemplateContentExample();
				cexample.setDistinct(true);
				cexample.setOrderByClause("template_area_name asc");
				cexample.createCriteria().andCustomerIdEqualTo(cId).andTemplateIdEqualTo(tId);
				customerTemplateContentList = CustomerTemplateContentService.selectByExample(cexample);

				if (ValidateUtil.isEmpty(customerTemplateContentList))
				{
					TemplateAreaExample areaExample = new TemplateAreaExample();
					areaExample.setDistinct(true);
					areaExample.setOrderByClause("name asc");
					areaExample.createCriteria().andTemplateIdEqualTo(tId);
					templateAreaList = templateAreaService.selectByExample(areaExample);
				}
			}
		} catch (Exception e)
		{
			logger.error("上传文件到服务器时异常", e);
		}
		return "config";
	}

	/**
	 * 保存模板内容配置，同时生成静态页面
	 * 
	 * @return
	 */
	public String config()
	{
		try
		{
			tId = Integer.parseInt(getAttributeFromSession("tId").toString());
			cId = getAttributeFromSession("cId").toString();

			String[] areaIdArray = areaIds.split(",");
			// 先删除原来可能存在的配置
			CustomerTemplateContentExample example = new CustomerTemplateContentExample();
			example.createCriteria().andTemplateIdEqualTo(tId).andCustomerIdEqualTo(cId);
			CustomerTemplateContentService.deleteByExample(example);

			// 根据模板ID获取到相应的模板数据
			/**
			 * 模板备用字段说明
			 * record.setBackup1(object.getString("childFtl"));//子模板名称，如相集模板中可以选择一个相册的模板名称。
			 * record.setBackup2(object.getString("jsonFile"));//JSON类型的模板，生成的JSON数据文件名称。
			 * record.setBackup3(object.getString("resourcesDir"));//模板相关其他资源的路径，到时候要把这些资源全部复制到客户的目录下
			 * record.setBackup4(object.getString("indexFile"));//JSON类型的模板的，访问首页文件名称
			 */
			Template template = templateService.selectByPrimaryKey(tId);
			if (Constant.TEMPLATE_TYPE_JSON.equalsIgnoreCase(template.getType()))
			{
				// JSON类型的模板
				// 保存配置
				for (String each : areaIdArray)
				{
					CustomerTemplateContent record = new CustomerTemplateContent();
					record.setTemplateId(tId);
					record.setCustomerId(cId);
					// arearid_
					record.setTemplateAreaId(Integer.valueOf(each));
					// arearname_
					record.setTemplateAreaName(request.getParameter("arearname_" + each));
					// contenttype_
					record.setContenttype(Integer.valueOf(request.getParameter("contenttype_" + each)));
					// title_
					record.setTitle(request.getParameter("title_" + each));
					// summary_
					record.setSummary(request.getParameter("summary_" + each));
					// content_
					record.setContent(request.getParameter("content_" + each));
					// backup1
					record.setBackup1(request.getParameter("backup1_" + each));
					// backup2
					record.setBackup2(request.getParameter("backup2_" + each));
					// backup3
					record.setBackup3(request.getParameter("backup3_" + each));
					// backup4
					record.setBackup4(request.getParameter("backup4_" + each));

					CustomerTemplateContentService.insertSelective(record);
					// 相集
					if (Constant.CONTENT_TYPE_ALBUMS == record.getContenttype())
					{
						// 取出相应的相集以及相集下的相片信息
						CustomerAlbumExample albumExample = new CustomerAlbumExample();
						albumExample.setDistinct(true);
						albumExample.setOrderByClause("id asc");
						List<Integer> albumIds = new ArrayList<Integer>();
						String[] allAlbumIds = record.getContent().split(",");
						for (String e : allAlbumIds)
							albumIds.add(Integer.parseInt(e));

						albumExample.createCriteria().andCustomeridEqualTo(cId).andIdIn(albumIds);
						record.setAlbumList(customerAlbumService.selectByExample(albumExample));
						// 为每一个相集生成JSON数据
						if (!ValidateUtil.isEmpty(record.getAlbumList()))
						{
							String jsonFile = template.getBackup2();
							String resourcesDir = template.getBackup3();
							String indexFile = template.getBackup4();
							
							//非标准的JSON格式，不能使用JSON API
							StringBuilder jsonContent = new StringBuilder();
							jsonContent.append("showPics([");
							
							String serverDomainUrl = Config.getProperty(Constant.SERVER_DOMAIN_URL) + "/";
							for (int i = 0; i < record.getAlbumList().size();i++ )
							{
								CustomerAlbum eachAlbum = record.getAlbumList().get(i);
								
								//查询出每个相集下的相册
								CustomerAlbumPhotoExample photoExample = new CustomerAlbumPhotoExample();
								photoExample.setDistinct(true);
								photoExample.setOrderByClause("id asc");
								photoExample.createCriteria().andAlbumidEqualTo(eachAlbum.getId());
								eachAlbum.setPhotoList(customerAlbumPhotoService.selectByExample(photoExample));
								
								int photoNum = eachAlbum.getPhotoNums();
								int halfPhotoNum = Math.round(photoNum / 2);
								jsonContent.append("{");
								jsonContent.append("title: '" + eachAlbum.getAlbumname() + "',");
								jsonContent.append("ps1: [");
								
								List<CustomerAlbumPhoto> photoList = eachAlbum.getPhotoList();
								for (int j = 0; j < halfPhotoNum; j++)
								{
									CustomerAlbumPhoto eachPhoto = photoList.get(j);
									if (j == 0)
										jsonContent.append("{type: 'title', title: '").append(eachAlbum.getAlbumname()).append("', subTitle: '").append(eachAlbum.getBackup1()).append("' },");
									
									jsonContent.append("{type: 'img', name: '").append(eachPhoto.getPhotoname()).append("', img: '").append(serverDomainUrl).append(eachPhoto.getSavefile()).append("', size: [").append(eachPhoto.getBackup1()).append("]}");
									
									if(j != (halfPhotoNum - 1))
										jsonContent.append(",");
								}
								jsonContent.append("],");
								jsonContent.append("ps2: [");
								for (int j = halfPhotoNum; j < photoNum; j++)
								{
									CustomerAlbumPhoto eachPhoto = photoList.get(j);
									if(j == (halfPhotoNum + 1))
										jsonContent.append("{type: 'text', content: '").append(eachAlbum.getAlbumsummary()).append("'},");
									
									jsonContent.append("{type: 'img', name: '").append(eachPhoto.getPhotoname()).append("', img: '").append(serverDomainUrl).append(eachPhoto.getSavefile()).append("', size: [").append(eachPhoto.getBackup1()).append("]}");
									
									if(j != (photoNum - 1))
										jsonContent.append(",");
								}
								jsonContent.append("]");
								jsonContent.append("}");
								if (i != (record.getAlbumList().size() - 1))
									jsonContent.append(",");
							}
							jsonContent.append("]);");
							logger.info("生成的JSON数据：" + jsonContent.toString());
							
							//获取到该模板需要保存的服务器地址
							String staticHtmlPageRelaPath = Constant.STATIC_FILE_RESOURCE_PATH.concat(File.separator).concat(cId).concat(
									File.separator).concat(template.getName());
							String staticHtmlPageAbsPath = SystemParamsLoader.getRealPath(staticHtmlPageRelaPath);
							String resourcesAbsPath = SystemParamsLoader.getRealPath(resourcesDir);
							//将模板中配置的相关资源的文件夹下所有文件全部复制到模板保存的文件夹下
							FileTool.copyDirectiory(resourcesAbsPath, staticHtmlPageAbsPath);
							
							//向模板中配置的JSON保存文件中输出拼装出来的JSON串
							String jsonFileAbsPath = SystemParamsLoader.getRealPath(staticHtmlPageRelaPath.concat(File.separator).concat(jsonFile));
							FileTool.copy(jsonContent.toString(), new File(jsonFileAbsPath));
							
							//拼装出该模板首页访问路径
							staticHtmlPath = serverDomainUrl + staticHtmlPageRelaPath.concat(File.separator) + indexFile;
						}
					}
				}
			} else
			{
				customerTemplateContentList = new ArrayList<CustomerTemplateContent>();
				// HTML类型的模板
				// 保存配置
				for (String each : areaIdArray)
				{
					CustomerTemplateContent record = new CustomerTemplateContent();
					record.setTemplateId(tId);
					record.setCustomerId(cId);
					// arearid_
					record.setTemplateAreaId(Integer.valueOf(each));
					// arearname_
					record.setTemplateAreaName(request.getParameter("arearname_" + each));
					// contenttype_
					record.setContenttype(Integer.valueOf(request.getParameter("contenttype_" + each)));
					// title_
					record.setTitle(request.getParameter("title_" + each));
					// summary_
					record.setSummary(request.getParameter("summary_" + each));
					// content_
					record.setContent(request.getParameter("content_" + each));
					// backup1
					record.setBackup1(request.getParameter("backup1_" + each));
					// backup2
					record.setBackup2(request.getParameter("backup2_" + each));
					// backup3
					record.setBackup3(request.getParameter("backup3_" + each));
					// backup4
					record.setBackup4(request.getParameter("backup4_" + each));

					// 特殊模板处理
					// 相集
					if (Constant.CONTENT_TYPE_ALBUMS == record.getContenttype())
					{
						// 取出相应的相集以及相集下的相片信息
						CustomerAlbumExample albumExample = new CustomerAlbumExample();
						albumExample.setDistinct(true);
						albumExample.setOrderByClause("id desc");
						List<Integer> albumIds = new ArrayList<Integer>();
						String[] allAlbumIds = record.getContent().split(",");
						for (String e : allAlbumIds)
							albumIds.add(Integer.parseInt(e));

						albumExample.createCriteria().andCustomeridEqualTo(cId).andIdIn(albumIds);
						record.setAlbumList(customerAlbumService.selectByExample(albumExample));
						// 为每一个相集生成静态的相册页面
						if (!ValidateUtil.isEmpty(record.getAlbumList()))
						{
							// 获取这个相集模板使用哪一个相册模板生成相集中的相片的静态化页面。
							String photoTemplateName = template.getBackup1();
							if (ValidateUtil.isEmpty(photoTemplateName))
								photoTemplateName = Config.getProperty(Constant.DEFAULT_PHOTOS_TEMP_NAME);

							//父级地址
							String parentUrl = Config.getPathProperty(Constant.SERVER_DOMAIN_URL)
									+ File.separator
									+ Constant.STATIC_FILE_RESOURCE_PATH.concat(File.separator).concat(cId).concat(File.separator).concat(
											template.getName()).concat(File.separator) + template.getName().concat(".html");

							for (CustomerAlbum eachAlbum : record.getAlbumList())
							{
								//查询出每个相集下的相册
								CustomerAlbumPhotoExample photoExample = new CustomerAlbumPhotoExample();
								photoExample.setDistinct(true);
								photoExample.setOrderByClause("id asc");
								photoExample.createCriteria().andAlbumidEqualTo(eachAlbum.getId());
								eachAlbum.setPhotoList(customerAlbumPhotoService.selectByExample(photoExample));
								
								List<CustomerTemplateContent> tempContentList = new ArrayList<CustomerTemplateContent>();
								tempContentList.addAll(customerTemplateContentList);

								CustomerTemplateContent tempContent = new CustomerTemplateContent();
								tempContent.setContenttype(Constant.CONTENT_TYPE_PHOTOS);
								tempContent.setPhotoList(eachAlbum.getPhotoList());
								tempContentList.add(tempContent);

								String albumPhotoStaticHtml = staticHtmlBuildService.buildAlbumPhotoStaticHtml(cId, eachAlbum.getId(),
										template.getName(), photoTemplateName, tempContentList, parentUrl);

								eachAlbum.setAlbumPhotoStaticHtml(albumPhotoStaticHtml);
							}
						}
					} else if (Constant.CONTENT_TYPE_VOTE == record.getContenttype())
					{
						// 投票
					} else if (Constant.CONTENT_TYPE_REVIEW == record.getContenttype())
					{
						// 专家点评
						ExpertReviewExample reviewExample = new ExpertReviewExample();
						reviewExample.setDistinct(true);
						reviewExample.setOrderByClause("id asc");
						String[] allReview = record.getContent().split(",");
						List<Integer> allReviewId = new ArrayList<Integer>();
						for (String eachReview : allReview)
							allReviewId.add(Integer.parseInt(eachReview));
						reviewExample.createCriteria().andCustomeridEqualTo(cId).andIdIn(allReviewId);
						record.setReviewList(expertReviewService.selectByExample(reviewExample));
					}
					customerTemplateContentList.add(record);
					CustomerTemplateContentService.insertSelective(record);
				}
				// 生成静态页面
				staticHtmlPath = staticHtmlBuildService.buildProductStaticHtml(cId, template.getName(), customerTemplateContentList);
			}
			// 回调产品接口，通知产品生成的静态化路径是多少?customerId=#{customerId}#&productId=#{productId}#&url=#{url}#
			if (Config.getProperty(Constant.CALLBACK_SWITCH).equals("1"))
			{
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("customerId", cId);
				paramMap.put("productId", getAttributeFromSession("pId").toString());
				paramMap.put("url", staticHtmlPath);
				String callbackResult = new HttpTools().sendHttpReqToServerUTF8(Config.getProperty(Constant.PRODUCT_GENERATE_CALLBACK_URL),
						paramMap);
				logger.info("产品静态化回调结果：" + callbackResult);
				if (!"204".equals(callbackResult))
					staticHtmlPath = null;
			} else
			{
				logger.info("回调开关设置为关闭，不回调，如需回调请修改配置项：callback_switch = 1");
			}
		} catch (Exception e)
		{
			logger.info("配置产品模板内容时，发生异常，原因：", e);
		}

		return "config_result";
	}

	public List<CustomerTemplateContent> getCustomerTemplateContentList()
	{
		return customerTemplateContentList;
	}

	public void setCustomerTemplateContentList(List<CustomerTemplateContent> customerTemplateContentList)
	{
		this.customerTemplateContentList = customerTemplateContentList;
	}

	public List<TemplateArea> getTemplateAreaList()
	{
		return templateAreaList;
	}

	public void setTemplateAreaList(List<TemplateArea> templateAreaList)
	{
		this.templateAreaList = templateAreaList;
	}

	public String getCId()
	{
		return cId;
	}

	public void setCId(String id)
	{
		cId = id;
	}

	public int getTId()
	{
		return tId;
	}

	public void setTId(int id)
	{
		tId = id;
	}

	public String getAreaIds()
	{
		return areaIds;
	}

	public void setAreaIds(String areaIds)
	{
		this.areaIds = areaIds;
	}

	public String getStaticHtmlPath()
	{
		return staticHtmlPath;
	}

	public void setStaticHtmlPath(String staticHtmlPath)
	{
		this.staticHtmlPath = staticHtmlPath;
	}

	public String getTName()
	{
		return tName;
	}

	public void setTName(String name)
	{
		tName = name;
	}
}
