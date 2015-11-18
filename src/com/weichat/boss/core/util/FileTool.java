/*
 * 版权所有 (C) 2001-2011 深圳市艾派应用系统有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、Nov 1, 2011，Administrator创建。 
 */
package com.weichat.boss.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.tools.ant.filters.StringInputStream;

public class FileTool
{
	private static final int BUFFER_SIZE = 16 * 1024;

	/**
	 * 适合字节流的文件复制 
	 * @param src
	 * @param dst
	 */
	public static void copy(File src, File dst)
	{
		try
		{
			InputStream in = null;
			OutputStream out = null;
			try
			{
				in = new BufferedInputStream(new FileInputStream(src));
				out = new BufferedOutputStream(new FileOutputStream(dst), in.available());
				byte[] buffer = new byte[in.available()];
				while (in.read(buffer) > 0)
				{
					out.write(buffer, 0, buffer.length);
				}
			} finally
			{
				if (null != in)
				{
					in.close();
				}
				if (null != out)
				{
					out.close();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void stringFileCopy(File src, File dst)
	{
		try
		{
			BufferedReader in = null;
			BufferedWriter out = null;
			try
			{

				in = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
				//in = new BufferedReader(new StringReader(content));
				//out = new BufferedWriter(new FileWriter(dst));
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst), "UTF-8"));
				String eachLine = null;
				while ((eachLine = in.readLine()) != null)
					out.write(eachLine);
			
				
				/*in = new BufferedReader(new FileReader(src));
				out = new BufferedWriter(new FileWriter(dst));
				String eachLine = null;
				while ((eachLine = in.readLine()) != null)
					out.write(eachLine);*/
			} finally
			{
				if (null != in)
				{
					in.close();
				}
				if (null != out)
				{
					out.close();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void copy(String content, File dst)
	{
		try
		{
			//BufferedReader in = new BufferedReader(            new InputStreamReader(new FileInputStream("infilename"), "UTF8"));
			BufferedReader in = null;
			BufferedWriter out = null;
			try
			{
				in = new BufferedReader(new InputStreamReader(new StringInputStream(content)));
				//in = new BufferedReader(new StringReader(content));
				//out = new BufferedWriter(new FileWriter(dst));
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst), "UTF-8"));
				String eachLine = null;
				while ((eachLine = in.readLine()) != null)
					out.write(eachLine);
			} finally
			{
				if (null != in)
				{
					in.close();
				}
				if (null != out)
				{
					out.close();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 复制文件夹
	public static void copyDirectiory(String sourceDir, String targetDir) throws IOException
	{
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++)
		{
			if (file[i].isFile())
			{
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
				copy(sourceFile, targetFile);
			}
			if (file[i].isDirectory())
			{
				// 准备复制的源文件夹
				String dir1 = sourceDir + File.separator + file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + File.separator + file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}
	
	public static void main(String[] args)
	{
		File dest = new File("D:\\微云网盘\\154052684\\aaa.js");
		copy("我是内容，你看着办吧", dest);
	}
}
