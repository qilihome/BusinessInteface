package com.weichat.boss.action.config;

import org.json.JSONArray;
import org.json.JSONObject;


public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		json.put("showPics", jsonArray);
		
		System.out.println(json.toString());

	}

}
