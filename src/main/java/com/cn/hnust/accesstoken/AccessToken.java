package com.cn.hnust.accesstoken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
* @author zn
* @version 创建时间：2017年1月18日 下午8:50:26
* 类说明
*/
public class AccessToken extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(AccessToken.class);
	
	@Override
	public void init() throws ServletException {
		
		ThreadAccessToken.appid = getInitParameter("appid");
		
		ThreadAccessToken.secret = getInitParameter("secret");
		logger.info("appid" + ThreadAccessToken.appid + "  " + "secret" + ThreadAccessToken.secret );
		
		if ("".equals(ThreadAccessToken.appid) && "".equals(ThreadAccessToken.secret)) {
			logger.error("appid and appsecret configuration error, please check carefully.");
		}else {
			Thread thread = new Thread(new ThreadAccessToken());
			thread.start();
		}	
	}
}
