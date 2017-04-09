package com.cn.hnust.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.service.WXMessageOutPutService;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��14�� ����12:15:06 ��˵��
 */
@Controller
@RequestMapping("/wx")
public class CheckWXController {

//	@Inject
//	private WXCheckService wXCheckService;

	@Inject
	private WXMessageOutPutService wXMessageOutPutService;

	// @RequestMapping("/checkwx")
	// @ResponseBody
	// public Long checkwx(String signature,String timestamp,String nonce,String
	// echostr){
	//
	// Boolean flg = wXCheckService.checkWX(signature, timestamp,
	// nonce,echostr);
	// if (flg) {
	// System.out.println(echostr);
	// return Long.valueOf(echostr);
	// }else {
	// return null;
	// }
	// }
	//

	@RequestMapping("/checkwx")
	@ResponseBody
	public String checkwx(HttpServletRequest request, HttpServletResponse response) {
		String message = null;
		response.setCharacterEncoding("UTF-8");
		try {
			message = wXMessageOutPutService.outPutToWx(request);
//			response.getWriter().print(message);
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping("/checkwxs")
	@ResponseBody
	public String checkwxs(HttpServletRequest request, HttpServletResponse response) {
		String message = null;
		response.setCharacterEncoding("UTF-8");
		try {
			
			return "顺丰到付的";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
