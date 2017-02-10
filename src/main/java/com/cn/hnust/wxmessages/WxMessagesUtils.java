package com.cn.hnust.wxmessages;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.util.JSONPObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.thoughtworks.xstream.XStream;

/**
 * @author zn
 * @version 创建时间：2017年1月16日 下午9:49:07 类说明
 */
public class WxMessagesUtils {
	/**
	 * 是否使用缓存
	 */
	public static Boolean UseCaches = null;
	
	/**
	 * 连接超时时间 单位毫秒
	 */
	public static Integer ConnectTimeout = null;
	
	/**
	 * 读取超时间 单位毫秒
	 */
	public static Integer ReadTimeout = null;
	
	/**
	 * 设置此 httpurlconnection 实例是否应该自动执行 http 重定向（响应代码为 3xx 的请求） 默认值来自 followredirects，其默认情况下为 true。
	 */
	public static Boolean InstanceFollowRedirects = false;

	public static final String TEXT = "text";
	public static final String IMAGE = "image";
	public static final String VOICE = "voice";
	public static final String VIDEO = "video";
	public static final String SHORT_VIDEO = "shortvideo";
	public static final String LOCATION = "location";
	public static final String LINK = "link";
	public static final String EVENT = "event";
	public static final String SUBSCRIBE = "subscribe";
	public static final String SCAN = "SCAN";
	public static final String UNSUBSCRIBE = "unsubscribe";
	
	/**
	 * 极速数据的appkey
	 */
	public static final String JISU_APP_KEY = "appkey";
	public static final String JISU_APP_KEY_VALUE = "a5ec7b9e7a5c3e2a";
	
	/**
	 * method 类型
	 */
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	
	public static Map<String, String> messageToMap(HttpServletRequest request) throws IOException, DocumentException {

		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();

		// 获取输入流
		InputStream inStream = request.getInputStream();
		Document document = reader.read(inStream);// 读取输入流到document操作里

		// 获取根节点

		Element root = document.getRootElement();

		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();

		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}

		inStream.close();
		return map;

	}

	public static String textToXml(com.cn.hnust.pojo.TextMessage textMessage) {

		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		System.out.println(xStream.toXML(textMessage));
		return xStream.toXML(textMessage);
	}

	/**
	 * 访问连接获取数据
	 * 
	 * @param strUrl
	 *            链接url
	 * @param param
	 *            map型参数 ,注:中文参数有些情况需要用 URLEncoder.encode(param,
	 *            "utf-8");转换utf-8编码格式参数
	 * @param method
	 *            访问类型 例如 get请求 或者 post 请求 可为 null
	 * @param property
	 *            map 型的请求头信息 可为null
	 * @return rs (String Data)
	 * @throws IOException
	 */
	public static String getUrlData(String strUrl, Map<String, Object> param, String method,
			Map<String, String> property) throws IOException {
		HttpURLConnection connection = null;
		BufferedReader read = null;
		String rs = null;
		InputStream in = null;
		DataOutputStream outputStream = null;
		try {
			if (method == null || method.equals("GET")) {
				strUrl = strUrl + "?" + urlencode(param);
			}
			URL url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();

			if (method == null || method.equals("GET")) {
				connection.setRequestMethod("GET");
			} else {
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
			}
			// 设置请求头
			if (property != null) {
				Iterator<Map.Entry<String, String>> iteratorMap = property.entrySet().iterator();
				while (iteratorMap.hasNext()) {
					Map.Entry<java.lang.String, java.lang.String> entry = iteratorMap.next();
					connection.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}

			if (UseCaches !=null) {
				connection.setUseCaches(UseCaches);
			}
			if (ConnectTimeout != null) {
				connection.setConnectTimeout(ConnectTimeout);
			}
			if (ReadTimeout != null) {
				connection.setReadTimeout(ReadTimeout);
			}
			connection.setInstanceFollowRedirects(InstanceFollowRedirects);
			
			connection.connect();

			if (param != null && method.equals("POST")) {
				try {
					outputStream = new DataOutputStream(connection.getOutputStream());
					outputStream.writeBytes(urlencode(param));
					outputStream.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			in = connection.getInputStream();
			read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String lists = null;
			StringBuffer sBuffer = new StringBuffer();
			while ((lists = read.readLine()) != null) {
				sBuffer.append(lists);
			}
			rs = sBuffer.toString();
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (read != null) {
				read.close();
			}
			if (in != null) {
				in.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (connection != null) {
				connection.disconnect();
			}

		}
		return rs;
	}

	// 将map型转为请求参数型
	public static String urlencode(Map<String, Object> param) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry i : param.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	
	public static <T> Object jsonObjectToJavaBean(String results,Class<T> tClass){
		JSONObject weather = JSONObject.parseObject(results); 
		return JSONObject.toJavaObject(weather,tClass);
	}
}
