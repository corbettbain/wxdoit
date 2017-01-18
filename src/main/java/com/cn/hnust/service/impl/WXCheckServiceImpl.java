package com.cn.hnust.service.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.cn.hnust.service.WXCheckService;
import com.cn.hnust.utils.CommUtils;

/**
* @author zn
* @version 创建时间：2017年1月14日 上午12:02:50
* 类说明
*/
@Service
public class WXCheckServiceImpl implements WXCheckService {

	public static final String token = "corbett";
	@Override
	public Boolean checkWX(String signature, String timestamp, String nonce,String echostr) {

		String[] check = new String[]{token,timestamp,nonce};
		Arrays.sort(check);
		
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < check.length; i++) {
			stringBuffer.append(check[i]);
		}
		String wxcheck = CommUtils.SHAEncodeAnother(stringBuffer.toString());
		return wxcheck.equals(signature); 
	}

}
