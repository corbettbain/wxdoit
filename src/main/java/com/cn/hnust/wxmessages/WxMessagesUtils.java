package com.cn.hnust.wxmessages;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

/**
* @author zn
* @version 创建时间：2017年1月16日 下午9:49:07
* 类说明
*/
public class WxMessagesUtils {

	public static Map<String,String> messageToMap(HttpServletRequest request) throws IOException, DocumentException{
		
		Map<String, String> map = new HashMap<>();
		SAXReader reader = new SAXReader();
		
		//获取输入流
		InputStream inStream = request.getInputStream();
		Document document = reader.read(inStream);//读取输入流到document操作里
		
		//获取根节点
		
		Element root = document.getRootElement();
		
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		
		for (Element element : list) {
			map.put(element.getName(),element.getText());
		}
		
		inStream.close();
		return map;
		
	}

	public static String textToXml(com.cn.hnust.pojo.TextMessage textMessage){
		
		XStream xStream = new XStream();
		xStream.alias("xml",textMessage.getClass());
		System.out.println(xStream.toXML(textMessage));
		return xStream.toXML(textMessage);
	}
	
}
