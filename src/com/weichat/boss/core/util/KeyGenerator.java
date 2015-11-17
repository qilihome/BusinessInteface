/*
 * 版权所有 (C) 2001-2013 深圳市艾派应用系统有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、Jan 11, 2013，yinxianwen创建。 
 */
package com.weichat.boss.core.util;

import java.util.Random;

import net.i314.web.util.DateTimeUtil;

public class KeyGenerator
{
	private static Random RANDOM = new Random();
	private static int KEY_INDEX = 1;
	public static final String PRODUCT_PARAM_KEY_PREFIX = "param_";
	private static final String PRODUCT_PARAM_KEY_TEMPLATE = "%s_%s";
	private static final String PRODUCT_NUMBER_TEMPLATE = "%s_%s";
	private static String LAST_PRODUCT_NUMBER = null;
	
	private static int ORDER_NUMBER_INDEX = 1;

	/**
	 * 自动生成商品参数的英文名称
	 * 
	 * @return
	 */
	public synchronized static String generatorProductParamKey()
	{
		return PRODUCT_PARAM_KEY_PREFIX
				+ String.format(PRODUCT_PARAM_KEY_TEMPLATE, DateTimeUtil.getDateTime12String(), KEY_INDEX++);
	}

	/**
	 * 生成商品号，以商品所属分类ID加下划线加8位数自动生成的序列号
	 * 
	 * @param productTypeId
	 * @return
	 */
	public synchronized static String generatorProductNumber(long productTypeId)
	{
		String numberStr = DateTimeUtil.getDateTime14String();
		if (numberStr.equals(LAST_PRODUCT_NUMBER))
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			numberStr = DateTimeUtil.getDateTime14String();
		}
		LAST_PRODUCT_NUMBER = numberStr;
		
		return String.format(PRODUCT_NUMBER_TEMPLATE, productTypeId, numberStr);
	}
	
	/**
	 * 生成订单号
	 * @return
	 */
	public synchronized static String generatorOrderNumber(){
		StringBuilder orderNumber = new StringBuilder();
		int codePoint = RANDOM.nextInt(26) + 97;//97 -122 为26个小写字母的ASCII码值
		//生成首位第一个字母
		//System.out.println(first);
		orderNumber.append((char)codePoint);
		
		//生成后续最多3位数字
		codePoint = RANDOM.nextInt(codePoint) + DateTimeUtil.getCurrentMinute() + DateTimeUtil.getCurrentHour() + DateTimeUtil.getCurrentWeek() + 100;
		//System.out.println(codePoint);
		orderNumber.append(codePoint);
		//生成后续最多4位数字
		codePoint = RANDOM.nextInt(codePoint) + 1000;
		//System.out.println(codePoint);
		orderNumber.append(codePoint);
		
		String index = "000" + ORDER_NUMBER_INDEX;
		ORDER_NUMBER_INDEX++;
		if(ORDER_NUMBER_INDEX > 1000)
			ORDER_NUMBER_INDEX = 1;
		
		orderNumber.append(index.substring(index.length() - 3));
		//System.out.println(orderNumber.toString());
		return orderNumber.toString();
	}

	public static void main(String[] args)
	{
		for (int i = 1; i < 100; i++)
		{
			System.out.println(generatorOrderNumber());
		}

	}
}
