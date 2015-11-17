package com.weichat.boss.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.i314.web.util.ValidateUtil;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 与HTTP服务器交互的相关工具类
 * 
 * @author ipi
 */
public class HttpTools
{
	private static class TrustAnyTrustManager implements X509TrustManager
	{

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
		{
		}

		public X509Certificate[] getAcceptedIssuers()
		{
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier
	{
		public boolean verify(String hostname, SSLSession session)
		{
			return true;
		}
	}

	private static Log log = LogFactory.getLog(HttpTools.class);

	/**
	 * 
	 */
	public HttpTools()
	{
	}

	public static String connectURL(String dest_url, String commString)
	{
		String rec_string = "";
		URL url = null;
		HttpURLConnection urlconn = null;
		try
		{
			url = new URL(dest_url);
			urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setRequestProperty("content-type", "text/xml");
			urlconn.setRequestMethod("POST");
			urlconn.setDoInput(true);
			urlconn.setDoOutput(true);
			OutputStream out = urlconn.getOutputStream();
			out.write(commString.getBytes("UTF-8"));
			out.flush();
			out.close();
			BufferedReader rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			int ch;
			while ((ch = rd.read()) > -1)
				sb.append((char) ch);
			rec_string = sb.toString();
			rd.close();
			urlconn.disconnect();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return rec_string;
	}

	public static byte[] getURLContents(String strURL)
	{
		// StringBuffer sb = new StringBuffer();
		try
		{
			URL url = new URL(strURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);// 可以输出
			connection.setDoInput(true);
			connection.connect();
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(connection.getInputStream()));
			// String line;
			// while ((line = in.readLine()) != null)
			// {
			// sb.append(line);
			// }
			InputStream is = connection.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			return data;
		} catch (Exception e)
		{
			log.error("Error 12" + e.getMessage());
		}
		return null;
	}

	/**
	 * 向Http服务器发送相应请求，将返回服务器响应的方法
	 * 
	 * @param httpServerUrl：Http请求地址
	 * @param httpReqXml：请求的报文
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 * @return：响应报文
	 * @throws HttpException
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String sendHttpsReqToServer(String httpServerUrl, String dateString) throws Exception
	{

		DataInputStream indata = null;
		DataOutputStream output = null;
		// byte[] buffer = new byte[4096];
		String str_return = "";
		try
		{
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());

			URL console = new URL(httpServerUrl);

			HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();

			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());

			// String dateString="<?xml version=\"1.0\"
			// encoding=\"UTF-8\"?><SIAP><SIAP-Header><TransactionID>20101117155323100001</TransactionID><Version>2.0</Version><MessageName>AuthenticateReq</MessageName><SendAddress><DeviceType>200</DeviceType><DeviceID>110000025</DeviceID></SendAddress><RecvAddress><DeviceType>0</DeviceType><DeviceID>SCS</DeviceID></RecvAddress><TestFlag>0</TestFlag></SIAP-Header><SIAP-Body><AuthenticateReq><BPID>110000025</BPID><BSID>1100000250000</BSID><UserID><ID>11000000070157</ID><Type>UCID</Type></UserID><VerifyInfo><Type>3</Type><Desc>MTI4OTIzMDY5NTExOXwwNTU1OTIwMDAwMDAwMDAwMDMyMDAwMDAyNDIwMTAxMTA4MTUzODE1</Desc><Value>RheoFNFYx/V/fnWqpUA56xnUg3DW8HOL/YGUvlBkfp0o5YIg2AecqTWITtP37zy5AX9zZ4bjgaN3nAuX2pUfAR0FoOQmnij5hBz1lQx5aJy6WA5fp6CgZaVyFtzlUBCRXRLloXVpGYa63ux/OzH588Lf+uF1deLoCnqG81+PDrk=</Value></VerifyInfo></AuthenticateReq></SIAP-Body></SIAP>";

			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-length", String.valueOf(dateString.length()));
			conn.setRequestProperty("Content-Type", "application/x-www- form-urlencoded");
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

			conn.connect();

			output = new DataOutputStream(conn.getOutputStream());
			output.writeBytes(dateString);

			InputStream is = conn.getInputStream();
			indata = new DataInputStream(is);
			String ret = "";

			while (ret != null)
			{
				ret = indata.readLine();
				if (ret != null && !ret.trim().equals(""))
				{
					str_return = str_return + new String(ret.getBytes("ISO-8859-1"), "GBK");
				}
			}
			conn.disconnect();
		} catch (ConnectException e)
		{
			log.error("ConnectException" + e);
			throw e;

		} catch (IOException e)
		{
			log.error("IOException" + e);
			throw e;

		} finally
		{
			try
			{
				if (indata != null)
					indata.close();
			} catch (Exception e)
			{
			}
			try
			{
				if (output != null)
					output.close();
			} catch (Exception e)
			{
			}
		}
		return str_return;
	}

	/**
	 * 向Http服务器发送相应请求，将返回服务器响应的方法
	 * 
	 * @param httpServerUrl：Http请求地址
	 * @param httpReqXml：请求的报文
	 * @return：响应报文
	 * @throws HttpException
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String sendHttpReqToServer(String httpServerUrl, String httpReqXml)
	{
		return sendHttpReqToServer(httpServerUrl, httpReqXml, null);
	}

	/**
	 * 向Http服务器发送相应请求，将返回服务器响应的方法
	 * 
	 * @param httpServerUrl：Http请求地址
	 * @param httpReqXml：请求的报文
	 * @return：响应报文
	 * @throws HttpException
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String sendHttpReqToServer(String httpServerUrl, String httpReqXml, Map<String, String> map)
	{

		// log.info("开始向Http服务端发送请求，请求地址：" + httpServerUrl + ",请求报文：" +
		// httpReqXml);

		String response = null;
		HttpClient client = null;
		PostMethod postMethod = null;
		BufferedReader br = null;
		try
		{
			client = new HttpClient();
			// 设置连接超时时间(单位毫秒)
			// client.setConnectionTimeout(30000); //为了解决CA延时问题，此代码必须注释掉
			// 设置读数据超时时间(单位毫秒)
			client.setTimeout(30000);

			postMethod = new PostMethod(httpServerUrl);
			postMethod.setRequestHeader("Connection", "close");
			if (httpReqXml != null && !httpReqXml.equals(""))
			{
				byte buf[] = httpReqXml.getBytes();
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				InputStream in = new BufferedInputStream(bais);
				postMethod.setRequestBody(in);
				// postMethod.setQueryString(httpReqXml);
			}

			if (map != null)
			{
				Set<String> set = map.keySet();
				for (String object : set)
				{
					postMethod.addParameter(object, map.get(object));
				}
			}

			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK)
			{
				log.info("Http请求成功");
			} else
			{
				log.info("Http请求失败");
			}

			InputStreamReader isr = new InputStreamReader(postMethod.getResponseBodyAsStream(), "UTF-8");
			br = new BufferedReader(isr);
			String eachLine = br.readLine();
			StringBuilder sb = new StringBuilder();
			while (eachLine != null)
			{
				sb.append(eachLine);
				eachLine = br.readLine();
			}

			response = sb.toString();
		} catch (HttpException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} catch (UnsupportedEncodingException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} catch (IOException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} finally
		{
			try
			{
				if (br != null)
					br.close();

				if (postMethod != null)
					postMethod.releaseConnection();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			client = null;
			postMethod = null;
		}
		return response;
	}

	/**
	 * 向Http服务器发送相应请求，将返回服务器响应的方法
	 * 
	 * @param httpServerUrl：Http请求地址
	 * @param httpReqXml：请求的报文
	 * @param map
	 *            参数
	 * @param encoding
	 *            编码
	 * @return：响应报文
	 * @throws HttpException
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public String sendHttpReqToServer(String httpServerUrl, String httpReqXml, Map<String, String> map, String encoding)
	{

		// log.info("开始向Http服务端发送请求，请求地址：" + httpServerUrl + ",请求报文：" +
		// httpReqXml);

		String response = null;
		HttpClient client = null;
		PostMethod postMethod = null;
		BufferedReader br = null;
		try
		{
			client = new HttpClient();

			// 设置连接超时时间(单位毫秒)
			client.setConnectionTimeout(30000);
			// 设置读数据超时时间(单位毫秒)
			client.setTimeout(30000);

			postMethod = new PostMethod(httpServerUrl);

			if (httpReqXml != null && !httpReqXml.equals(""))
			{
				byte buf[] = httpReqXml.getBytes();
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				InputStream in = new BufferedInputStream(bais);
				postMethod.setRequestBody(in);
				// postMethod.setQueryString(httpReqXml);
			}

			if (map != null)
			{
				Set<String> set = map.keySet();
				for (String object : set)
				{
					postMethod.addParameter(object, map.get(object));
				}
			}

			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK)
			{
				log.info("Http请求成功");
			} else
			{
				log.info("Http请求失败");
			}
			String enCode = encoding;
			if (ValidateUtil.isEmpty(enCode))
			{
				enCode = "UTF-8";
				log.info("使用默认编码处理:" + enCode);
			}
			InputStreamReader isr = new InputStreamReader(postMethod.getResponseBodyAsStream(), enCode);
			br = new BufferedReader(isr);
			String eachLine = br.readLine();
			StringBuilder sb = new StringBuilder();
			while (eachLine != null)
			{
				sb.append(eachLine);
				eachLine = br.readLine();
			}

			response = sb.toString();
		} catch (HttpException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} finally
		{
			try
			{
				if (br != null)
					br.close();

				if (postMethod != null)
					postMethod.releaseConnection();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			client = null;
			postMethod = null;
		}
		return response;
	}

	/**
	 * 为了适应12580那边的接口需求，特定开发了这个方法。 以get的方式去请求
	 * 
	 * @param httpServerUrl
	 * @param map
	 * @param encoding
	 * @return
	 */
	public String sendHttpReqToServerByGet(String httpServerUrl, Map<String, String> map, String encoding)
	{

		String response = null;
		HttpClient client = null;
		HttpMethod method = null;
		BufferedReader br = null;
		StringBuilder url = new StringBuilder();
		try
		{
			if (map != null)
			{
				for (Map.Entry<String, String> entry : map.entrySet())
				{
					url.append("&").append(entry.getKey()).append("=").append(entry.getValue());
				}
			}
			if (url.length() > 0)
			{
				if (httpServerUrl.indexOf("?") == -1)
				{
					httpServerUrl = httpServerUrl + "?" + url.substring(1);
				} else
				{
					httpServerUrl += url.toString();
				}
			}
			log.info("Get方式请求的Url:" + httpServerUrl);
			client = new HttpClient();

			// 设置连接超时时间(单位毫秒)
			client.setConnectionTimeout(30000);
			// 设置读数据超时时间(单位毫秒)
			client.setTimeout(30000);

			method = new GetMethod(httpServerUrl);
			int statusCode = client.executeMethod(method);
			if (statusCode == HttpStatus.SC_OK)
			{
				log.info("Http请求成功");
			} else
			{
				log.info("Http请求失败");
			}
			String enCode = encoding;
			if (ValidateUtil.isEmpty(enCode))
			{
				enCode = "UTF-8";
				log.info("使用默认编码处理:" + enCode);
			}
			InputStreamReader isr = new InputStreamReader(method.getResponseBodyAsStream(), enCode);
			br = new BufferedReader(isr);
			String eachLine = br.readLine();
			StringBuilder sb = new StringBuilder();
			while (eachLine != null)
			{
				sb.append(eachLine);
				eachLine = br.readLine();
			}

			response = sb.toString();
		} catch (HttpException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} finally
		{
			try
			{
				if (br != null)
				{
					br.close();
					br = null;
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			if (method != null)
				method.releaseConnection();
			client = null;
			method = null;
		}
		return response;
	}

	public static void main(String[] args) throws UnsupportedEncodingException
	{

		/*
		 * String url = "http://tuan.dghui.com/synuser.php"; String context =
		 * "username=BCD001" + "&password=111111" + "&mobile=" + 3 +
		 * "&email=1114@139.com" ; Map<String ,String > map=new HashMap<String,
		 * String>(); map.put("username", "BCD001"); map.put("password",
		 * "111111"); map.put("mobile", "13412011234"); map.put("email",
		 * "1114@139.com"); log.info("发送注册同步请求【MCP-->莞惠团】 url[" + url + "]
		 * conetx[" + context + "]");
		 *//*
			 * byte[] data =
			 * HttpTools.getURLContents("http://211.136.216.2/BJWZ/BjPc.ashx?Md5Str=argo_bj&Mobile=111&Type=1&Ccid=020&Num=0&VIN=4259&CarNo=SPE393&CarStyle=01");
			 * log.info(new String(data)); try { log.info(new String(data,
			 * "UTF-8")); } catch (UnsupportedEncodingException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } List<CarInfo>
			 * list = SaxRequestDecoder.decodeCarInfoList(data);
			 * log.info(list.get(0).getMessage());
			 */
		// log.info("收到注册同步响应【莞惠团-->MCP】 result[" + result + "]");
		/*
		 * marketingActiveId= product=扣30元送电影票2张 count=1 phone=13600255556
		 * vdate=2011-09-22 seq=20110722154520001 username=10086
		 * password=75a3c77cc01121ab76041a026b75f574 bustype=2 amount=30
		 * paytype=1
		 */
		// Map<String ,String > map=new HashMap<String, String>();
		// map.put("marketingActiveId", "");
		// map.put("product", "扣30元送电影票2张");
		// map.put("count", "1");
		// map.put("phone", "13600255556");
		// map.put("vdate", "2011-09-22");
		// map.put("seq", "20110722154520001");
		// map.put("username", "10086");
		// map.put("password", "75a3c77cc01121ab76041a026b75f574");
		// map.put("bustype", "2");
		// map.put("amount", "30");
		// map.put("paytype", "1");
		// HttpTools ht = new HttpTools();
		// String resultStr =
		// ht.sendHttpReqToServerUTF8("http://localhost:8086/exchangeServlet.action",
		// map);
		// log.info(resultStr);
		HttpTools ht = new HttpTools();
		String url = "http://211.136.202.19:8099/TuoWebOrder/TuoTongPiaoCityService?opt=tongPiaoTicketUse";
		Map<String, String> map = new HashMap<String, String>();
		map.put("opt", "tongPiaoFilmCouponDownload");
		String servMobile = URLEncoder.encode("大地3D", "UTF-8");

		map.put("servMobile", servMobile);
		String resultStr = ht.sendHttpReqToServerByGet(url, map, null);
		log.info(resultStr);
	}

	private static class UTF8PostMethod extends PostMethod
	{
		public UTF8PostMethod(String url)
		{
			super(url);
		}

		@Override
		public String getRequestCharSet()
		{
			// return super.getRequestCharSet();
			return "UTF-8";
		}
	};

	@SuppressWarnings("deprecation")
	public String sendHttpReqToServerUTF8(String httpServerUrl, Map<String, String> map)
	{

		String response = null;
		HttpClient client = null;
		PostMethod postMethod = null;
		BufferedReader br = null;
		try
		{
			client = new HttpClient();

			// 设置连接超时时间(单位毫秒)
			client.setConnectionTimeout(30000);
			// 设置读数据超时时间(单位毫秒)
			client.setTimeout(30000);

			// postMethod = new PostMethod(httpServerUrl);
			postMethod = new UTF8PostMethod(httpServerUrl);// 创建PostMethod的重写编码为UTF-8的子类
			if (map != null)
			{
				Set<String> set = map.keySet();
				for (String object : set)
				{
					postMethod.addParameter(object, map.get(object));
				}
			}
			log.info(postMethod.getRequestCharSet());
			int statusCode = client.executeMethod(postMethod);
			if (statusCode == HttpStatus.SC_OK)
			{
				log.info("Http请求成功");
			} else
			{
				log.info("Http请求失败");
			}

			InputStreamReader isr = new InputStreamReader(postMethod.getResponseBodyAsStream(), "UTF-8");
			br = new BufferedReader(isr);
			String eachLine = br.readLine();
			StringBuilder sb = new StringBuilder();
			while (eachLine != null)
			{
				sb.append(eachLine);
				eachLine = br.readLine();
			}

			response = sb.toString();
		} catch (HttpException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			log.error("向Http服务端发送请求时发生异常，请检查服务端地址", e);
		} finally
		{
			try
			{
				if (br != null)
					br.close();

				if (postMethod != null)
					postMethod.releaseConnection();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			client = null;
			postMethod = null;
		}
		return response;
	}
}
