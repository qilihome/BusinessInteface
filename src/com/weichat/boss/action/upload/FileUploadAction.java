/*
 * 版权所有 (C) 2001-2013 深圳市艾派应用系统有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、Jan 9, 2013，yinxianwen创建。 
 */
package com.weichat.boss.action.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.core.base.Constant;
import com.weichat.boss.core.util.FileTool;

/**
 * 全局性的文件上传类
 */
public class FileUploadAction extends BaseAction
{
	private static final long serialVersionUID = -7413974423607224192L;
	private static final Logger logger = Logger.getLogger(FileUploadAction.class);
	private static List<String> IMG_FILE_TYPE = new ArrayList<String>();
	static{
		IMG_FILE_TYPE.add(".JPG");
		IMG_FILE_TYPE.add(".GIF");
		IMG_FILE_TYPE.add(".PNG");
	}
	private String areaName;
	private File fileData;// 封装上传文件
	private String fileDataFileName;// 设置上传文件的文件名
	private String fileDataContentType;// 上传文件的类型

	/**
	 * 上传产品配置中的各种资源，包括图片，视频，音频等
	 * 
	 * @return
	 */
	public void upload()
	{
		JSONObject jsonResult = new JSONObject();
		PrintWriter writer = null;
		try
		{
			String fileType = fileDataFileName.substring(fileDataFileName.indexOf("."));
			String newFileName = UUID.randomUUID().toString() + fileType;

			// 绝对存储路径 域名/html/客户编号/模板名称/区域名称/资源文件
			String path = Constant.STATIC_FILE_RESOURCE_PATH + File.separator + getAttributeFromSession("cId") + File.separator
					+ getAttributeFromSession("tName") + File.separator + areaName + File.separator;// db存储路径
			String absPath = getContextRealPath() + path;

			File absDir = new File(absPath);
			if (!absDir.exists())
			{
				absDir.mkdirs();
			}
			File saveFile = new File(absPath, newFileName);

			FileTool.copy(fileData, saveFile);
			
			//如果是图片，算出图片的尺寸，可能有的模板需要使用到
			if (IMG_FILE_TYPE.contains(fileType.toUpperCase().trim()))
			{
				BufferedImage image = ImageIO.read(fileData);
				int width = image.getWidth();
				int height = image.getHeight();
				jsonResult.put("size", width + ", " + height);
			}

			jsonResult.put("result", true);
			jsonResult.put("path", path.replace(File.separator.charAt(0), '/').concat(newFileName));

		} catch (Exception e)
		{
			logger.error("上传文件到服务器时异常", e);
			jsonResult.put("result", false);
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

	public File getFileData()
	{
		return fileData;
	}

	public String getFileDataFileName()
	{
		return fileDataFileName;
	}

	public String getFileDataContentType()
	{
		return fileDataContentType;
	}

	public void setFileData(File fileData)
	{
		this.fileData = fileData;
	}

	public void setFileDataFileName(String fileDataFileName)
	{
		this.fileDataFileName = fileDataFileName;
	}

	public void setFileDataContentType(String fileDataContentType)
	{
		this.fileDataContentType = fileDataContentType;
	}

	public String getAreaName()
	{
		return areaName;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}
}
