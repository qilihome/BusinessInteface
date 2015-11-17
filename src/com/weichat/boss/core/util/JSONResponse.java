package com.weichat.boss.core.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class JSONResponse
{

    private Integer statusCode = 200; // 默认200 返回成功 300错误

    private String message = "操作成功"; // 200对应成功

    private String forwardUrl;

    private String callbackType;

    private String navTabId;

    public void printJSON() throws IOException
    {

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("statusCode", statusCode);
        jsonResult.put("message", message);
        jsonResult.put("callbackType", callbackType);
        jsonResult.put("fowrwardUrl", forwardUrl);
        jsonResult.put("navTabId", navTabId);

        String json = jsonResult.toString();

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8"); // 务必，防止返回文件名是乱码
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        out.print(json);
        out.close();

    }

    public String getCallbackType()
    {
        return callbackType;
    }

    public void setCallbackType(String callbackType)
    {
        this.callbackType = callbackType;
    }

    public String getForwardUrl()
    {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl)
    {
        this.forwardUrl = forwardUrl;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode)
    {
        this.statusCode = statusCode;
    }

    public String getNavTabId()
    {
        return navTabId;
    }

    public void setNavTabId(String navTabId)
    {
        this.navTabId = navTabId;
    }

}
