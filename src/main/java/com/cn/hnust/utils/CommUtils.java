package com.cn.hnust.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zn
 * @version 创建时间：2017年1月14日 上午12:10:46 类说明
 */
public class CommUtils {

	public static String SHAEncodeAnother(String inStr) {
		if (null == inStr || 0 == inStr.length()) {
			return null;
		}
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(inStr.getBytes("UTF-8"));

			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] buf = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

//	public static Weather getWeather(String city) throws IOException {
//		HttpURLConnection connection = null;
//		BufferedReader read = null;
//		String rs = null;
//		InputStream in = null; 
//		PrintWriter out = null;  
//		try {
////			String s1=URLEncoder.encode(city, "utf-8");
////			URL url = new URL(WEATHER_URL+s1);
////			
////			String city1 = "崇仁";
//			String s1=URLEncoder.encode(city, "utf-8");
//			URL url = new URL("http://api.jisuapi.com/weather/query?appkey=a5ec7b9e7a5c3e2a&city="+s1);
//			connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");
//			
//			connection.connect();
//			in = connection.getInputStream();
//			read = new BufferedReader(new InputStreamReader(in,"UTF-8"));
//			String lists = null;
//			StringBuffer sBuffer = new StringBuffer();
//			while((lists = read.readLine()) != null){
//				sBuffer.append(lists);
//			}
//			rs = sBuffer.toString();
//			System.out.println(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if (read != null) {
//				read.close();
//			}
//			if (connection != null) {
//				connection.disconnect();
//			}
//			if (in != null) {
//				in.close();
//			}
//		}
//		return null;
//	}

}
