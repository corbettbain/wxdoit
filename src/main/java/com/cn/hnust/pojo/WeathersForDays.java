package com.cn.hnust.pojo;

import java.util.Date;
import java.util.List;
import com.cn.hnust.pojo.Weather;;

/**
* @author zn
* @version ����ʱ�䣺2017��1��17�� ����10:00:06
* ��˵��
*/
public class WeathersForDays {

	private String city;
	
	private String cityid;
		
	private Date date;
	
	private String week;

	private String weather;

	private String temp;
	
	private String temphigh;
	
	private String templow;
	
	private String img;
	
	private String humidity;
	
	private String pressure;
	
	private String windspeed;
	
	private String winddirect;
	
	private String windpower;
	
	private String updatetime;
	
	private List<Hourly> hourlies;
}
