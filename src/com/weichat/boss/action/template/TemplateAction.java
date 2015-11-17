/**
 * 
 */
package com.weichat.boss.action.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import net.i314.web.util.DateTimeUtil;
import net.i314.web.util.ValidateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.core.base.Constant;
import com.weichat.boss.core.decompress.Decompression;
import com.weichat.boss.core.util.Config;
import com.weichat.boss.core.util.FileTool;
import com.weichat.boss.core.util.JSONUtil;
import com.weichat.boss.data.pojo.CustomerTemplateContentExample;
import com.weichat.boss.data.pojo.Template;
import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.TemplateAreaExample;
import com.weichat.boss.data.pojo.TemplateExample;
import com.weichat.boss.service.template.TemplateService;
import com.weichat.boss.service.templatearea.TemplateAreaService;
import com.weichat.boss.service.templatecontent.CustomerTemplateContentService;

/**
 * 模板管理
 * @author yinxianwen
 * 
 */
public class TemplateAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;

	private static final Logger logger = Logger.getLogger(TemplateAction.class);

	@Autowired
	private TemplateService templateService;
	@Autowired
	private TemplateAreaService templateAreaService;
	@Autowired
	private CustomerTemplateContentService customerTemplateContentService;

	// 删除
	private String ids;

	// 模板列表
	private List<Template> templateList;

	// 模板上传
	private File fileData;
	private String fileDataFileName;
	private String fileDataContentType;

	/**
	 * 模板列表
	 * 
	 * @return
	 */
	public String list()
	{
		try
		{
			TemplateExample example = new TemplateExample();
			example.setDistinct(true);
			example.setOrderByClause("addtime desc");

			templateList = templateService.selectByExample(example);
			return LIST;
		} catch (Exception e)
		{
			logger.error("查询模板列表异常", e);
			return ERROR;
		}
	}

	/**
	 * 到模板上传页面
	 * 
	 * @return
	 */
	public String uploadInit()
	{
		return "upload";
	}

	/**
	 * 上传广告图片
	 * 
	 * @return
	 */
	public void upload()
	{
		PrintWriter writer = null;
		JSONObject jsonResult = new JSONObject();
		try
		{
			String uploadPath = Config.getPathProperty(Constant.FILE_TEMPLATE_TEMP_PATH);
			String absPath = getContextRealPath() + uploadPath + File.separator
					+ fileDataFileName.substring(0, fileDataFileName.lastIndexOf(".")) + File.separator;// 绝对存储路径

			File absDir = new File(absPath);
			if (!absDir.exists())
			{
				absDir.mkdirs();
			}
			File saveFile = new File(absPath, fileDataFileName);
			FileTool.copy(fileData, saveFile);

			// 解压缩
			String tempFile = absPath + File.separator + fileDataFileName;
			Decompression.unzip(tempFile, saveFile.getParent() + File.separator);

			// 插入数据库
			boolean insertResult = insert(absPath, fileDataFileName.substring(0, fileDataFileName.lastIndexOf(".")));

			if (insertResult)
			{
				jsonResult.put("result", true);
				jsonResult.put("message", "模板上传成功");
			} else
			{
				jsonResult.put("result", false);
				jsonResult.put("message", "模板上传失败，请重试");
			}
		} catch (Exception e)
		{
			logger.error("上传文件到服务器时异常", e);
			jsonResult.put("result", false);
			jsonResult.put("message", "模板上传失败，请重试");
		} finally
		{
			try
			{
				if (writer != null)
				{
					writer.close();
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		writeJsonAjaxResponse(jsonResult.toString());
	}

	/**
	 * 保存模板数据与模板区域数据
	 * 
	 * @param templatePath
	 * @param name
	 * @throws IOException
	 */
	private boolean insert(String templatePath, String name) throws IOException
	{
		String stream = "";
		String filename = templatePath + File.separator + name + ".js";
		BufferedReader reader = null;

		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			String buffer;
			while ((buffer = reader.readLine()) != null)
			{
				stream += buffer;
			}
		} catch (IOException ex)
		{
			ex.printStackTrace();
			return false;
		} finally
		{
			reader.close();
		}

		try
		{
			JSONUtil object = new JSONUtil();
			object.fromObject(stream);

			// 获取模板区域信息
			JSONArray areaArray = object.getJSONArray("AREA");

			// 保存模板，只有当模板中有定义有效的区域的时候
			if (areaArray != null && areaArray.size() > 0)
			{
				Template record = new Template();
				record.setName(name);
				record.setType(object.getString("type"));
				record.setSummary(object.getString("summary"));
				record.setAreanum(areaArray.size());
				record.setAddtime(DateTimeUtil.getDateTimeString());
				record.setBackup1(object.getString("childFtl"));//子模板名称，如相集模板中可以选择一个相册的模板名称。
				record.setBackup2(object.getString("jsonFile"));//JSON类型的模板，生成的JSON数据文件名称。
				record.setBackup3(object.getString("resourcesDir"));//模板相关其他资源的路径，到时候要把这些资源全部复制到客户的目录下
				record.setBackup4(object.getString("indexFile"));//JSON类型的模板的，访问首页文件名称
				int addResult = templateService.insertSelective(record);
				int templateId = 0;
				if (addResult > 0)
				{
					TemplateExample example = new TemplateExample();
					example.setDistinct(true);
					example.createCriteria().andNameEqualTo(name).andTypeEqualTo(record.getType()).andSummaryEqualTo(record.getSummary())
							.andAreanumEqualTo(record.getAreanum()).andAddtimeEqualTo(record.getAddtime());

					List<Template> selectResult = templateService.selectByExample(example);
					if (!ValidateUtil.isEmpty(selectResult))
						templateId = selectResult.get(0).getId();
				}

				// 保存模板区域
				if (templateId > 0)
				{
					for (int i = 0; i < areaArray.size(); i++)
					{
						JSONObject obj = (JSONObject) areaArray.get(i);

						TemplateArea templateArea = new TemplateArea();
						templateArea.setName(obj.getString("name"));
						templateArea.setContenttype((int) obj.getLong("contentType"));
						templateArea.setTemplateId(templateId);

						templateAreaService.insertSelective(templateArea);
					}

					return true;
				}
			}
		} catch (Exception ex)
		{
			logger.info("保存模板时发生异常，原因：" + ex);
		}
		return false;
	}

	/**
	 * 删除模板
	 * 
	 * @return
	 */
	public String batchDelete()
	{
		try
		{
			if (!ValidateUtil.isEmpty(ids))
			{
				String[] delIds = ids.split(",");
				for (String id : delIds)
				{
					if (id != null)
					{
						int delResult = templateService.deleteByPrimaryKey(Integer.parseInt(id));
						if (delResult > 0)
						{
							//删除模板区域
							TemplateAreaExample example = new TemplateAreaExample();
							example.createCriteria().andTemplateIdEqualTo(Integer.parseInt(id));
							templateAreaService.deleteByExample(example);
							
							//删除配置的模板内容
							CustomerTemplateContentExample ctcexample = new CustomerTemplateContentExample();
							ctcexample.createCriteria().andTemplateIdEqualTo(Integer.parseInt(id));							
							customerTemplateContentService.deleteByExample(ctcexample);
						}
					}
				}
				message = "删除模板成功！";
			}
			return list();
		} catch (Exception e)
		{
			logger.error("批量删除模板异常", e);
			message = "删除模板失败！";
			return ERROR;
		}
	}
	
	public File getFileData()
	{
		return fileData;
	}

	public void setFileData(File fileData)
	{
		this.fileData = fileData;
	}

	public String getFileDataFileName()
	{
		return fileDataFileName;
	}

	public void setFileDataFileName(String fileDataFileName)
	{
		this.fileDataFileName = fileDataFileName;
	}

	public String getFileDataContentType()
	{
		return fileDataContentType;
	}

	public void setFileDataContentType(String fileDataContentType)
	{
		this.fileDataContentType = fileDataContentType;
	}

	public List<Template> getTemplateList()
	{
		return templateList;
	}

	public void setTemplateList(List<Template> templateList)
	{
		this.templateList = templateList;
	}

	public String getIds()
	{
		return ids;
	}

	public void setIds(String ids)
	{
		this.ids = ids;
	}
}
