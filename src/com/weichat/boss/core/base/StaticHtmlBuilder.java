package com.weichat.boss.core.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 静态化页面生成器
 */
public class StaticHtmlBuilder
{
	private static final Logger logger = Logger.getLogger(StaticHtmlBuilder.class);

	public static boolean buildStaticHtmlPage(Map<String, Object> contextData, String staticHtmlPageAbsPath, String ftlTemplateFileAbsPath,
			String ftlTemplateFileName, String staticHtmlPageEncoding)
	{
		logger.info(String.format("准备生成静态页面，静态页面保存路径：%s，模块文件存放路径：%s，模块文件名称：%s", staticHtmlPageAbsPath, ftlTemplateFileAbsPath,
				ftlTemplateFileName));
		Writer out = null;
		try
		{
			Configuration config = new Configuration();
			config.setDirectoryForTemplateLoading(new File(ftlTemplateFileAbsPath));
			config.setObjectWrapper(new DefaultObjectWrapper());
			config.setEncoding(Locale.getDefault(), staticHtmlPageEncoding);

			Template template = config.getTemplate(File.separator + ftlTemplateFileName.concat(File.separator).concat(ftlTemplateFileName).concat(".ftl"));
			template.setEncoding(staticHtmlPageEncoding);

			File savePathFile = new File(staticHtmlPageAbsPath);
			if (!savePathFile.exists())
			{
				savePathFile.mkdirs();
			}
			File finalFile = new File(staticHtmlPageAbsPath, ftlTemplateFileName.concat(".html"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(finalFile), staticHtmlPageEncoding));
			template.process(contextData, out);

			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.info("生成静态页面时发生异常..." + e);
			return false;
		} finally
		{
			if (null != out)
			{
				try
				{
					out.flush();
					out.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					out = null;
				}
			}

		}

	}
}
