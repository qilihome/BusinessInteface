package com.weichat.boss.core.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
	static JSONObject object;
	
	public JSONUtil fromObject(String stream){
		try{
			object = JSONObject.fromObject(stream);
		}
		catch(Exception ex){
			return null;
		}
		return this;
	}
	
	public Long getLong(String type){
		try{
			return object.getLong(type);
		}
		catch(Exception ex){
		}		
		return null;
	}
	
	public String getString(String type){
		try{
			return object.getString(type);
		}
		catch(Exception ex){			
		}		
		return null;
	}
	
	public JSONArray getJSONArray(String type){
		try{
			return object.getJSONArray(type);
		}
		catch(Exception ex){	
		}
		return null;
	}
}
