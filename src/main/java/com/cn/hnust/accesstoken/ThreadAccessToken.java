package com.cn.hnust.accesstoken;

import java.io.IOException;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
* @author zn
* @version 创建时间：2017年1月18日 下午8:55:10
* 类说明
*/
public class ThreadAccessToken implements Runnable{

	private Logger logger = Logger.getLogger(ThreadAccessToken.class);
	
	private static String grant_type = "client_credential";
	
	public static String appid = "";
	
	public static String secret = "";
	
	public static String accessToken = null;
	
	
	@Override
	public void run() {
		
		while (true) {
			JSONObject jsonObject = new JSONObject();
			String expires_in = null;
			try {
				jsonObject = GetAccessTokenUtils.getAccessToken(grant_type,appid, secret);
				accessToken = jsonObject.getString("access_token");							
				
				expires_in = jsonObject.getString("expires_in");
				
				logger.info("accessToken:" + accessToken + "expires_in:" + expires_in);
				
				if (accessToken != null) {
					Thread.sleep((Long.valueOf(expires_in)-200)*1000);
				}else {
					Thread.sleep(60*1000);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("ThreadAccessToken:" + e);
				e.printStackTrace();
				try {
					Thread.sleep(60*1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
