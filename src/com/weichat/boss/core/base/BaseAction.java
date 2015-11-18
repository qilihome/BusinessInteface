package com.weichat.boss.core.base;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.i314.web.page.PageResult;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1532308476578783183L;
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	protected static final String LIST = "list";
	protected static final String ADD = "add";
	protected static final String EDIT = "edit";
	protected static final String APPROVAL = "approval";
	protected static final String DETAIL = "detail";
	protected static final String SEARCH = "search";
	protected static final String VIEW = "view";
	protected static final String IMP = "imp";
	protected static final String ORDER = "order";

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	protected String message;
	protected String systemErrorMessage = getText("tip.system.error");
	protected int page = 1;
	protected PageResult pageResult;

	// ===================================
	/**
	 * 异步输出json格式的响应
	 * 
	 * @param response
	 */
	protected void writeJsonAjaxResponse(String response)
	{
		try
		{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("UTF8");
			resp.setContentType("text/json;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			writer.write(response);
			writer.flush();
		} catch (Exception e)
		{
			logger.error("包装ajax请求时异常", e);
		}
	}

	/**
	 * 异步输出普通字符串格式的响应
	 * 
	 * @param responseContent
	 */
	protected void ajaxPack(String responseContent)
	{
		try
		{
			PrintWriter out = null;
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.write(responseContent);
			out.flush();
			out.close();
		} catch (Exception e)
		{
			logger.error("包装ajax请求时异常", e);
		}
	}

	/**
	 * 流方式导出数据到excel表格中
	 * 
	 * @param fileName
	 * @param datas
	 * @throws Exception
	 */
	protected void exportExcel(String fileName, byte[] datas) throws Exception
	{
		fileName = URLEncoder.encode(fileName, "UTF-8");// 兼容IE6，此处设置需IE选项中urf-8选项支持
		fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xls");// attachment
		response.setContentLength(datas.length);
		ServletOutputStream ouputStream = response.getOutputStream();

		ouputStream.write(datas, 0, datas.length);
		ouputStream.flush();
		ouputStream.close();
	}

	public void setServletRequest(HttpServletRequest req)
	{
		this.request = req;
		this.session = req.getSession();
	}

	protected void setAttributeToSession(String key, Object value)
	{
		session.setAttribute(key, value);
	}

	protected Object getAttributeFromSession(String key)
	{
		return session.getAttribute(key);
	}

	public String getContextRealPath()
	{
		return ServletActionContext.getServletContext().getRealPath("/");
	}

	public void addActionError(String tip)
	{
		message = tip;
	}

	public String left()
	{
		return SUCCESS;
	}

	public String right()
	{
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse resp)
	{
		this.response = resp;
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public HttpServletResponse getResponse()
	{
		return response;
	}

	public void setResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	/**
	 * @return Returns the message.
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            The message to set.
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}

	/**
	 * @return Returns the page.
	 */
	public int getPage()
	{
		return page;
	}

	/**
	 * @param page
	 *            The page to set.
	 */
	public void setPage(int page)
	{
		this.page = page;
	}

	/**
	 * @return Returns the systemErrorMessage.
	 */
	public String getSystemErrorMessage()
	{
		return systemErrorMessage;
	}

	/**
	 * @param systemErrorMessage
	 *            The systemErrorMessage to set.
	 */
	public void setSystemErrorMessage(String systemErrorMessage)
	{
		this.systemErrorMessage = systemErrorMessage;
	}

	public PageResult getPageResult()
	{
		return pageResult;
	}

	public void setPageResult(PageResult pageResult)
	{
		this.pageResult = pageResult;
	}
}