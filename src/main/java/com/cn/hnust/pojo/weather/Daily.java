package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version 创建时间：2017年1月19日 下午7:25:32 类说明:一天的天气,分为白天和晚上
 */
public class Daily {

	private String date;//日期
	
	private String week;//星期
	
	private String sunrise;//日出
	
	private String sunset;//日落
	
	private Night night;//晚上天气
	
	private Day day;//白天天气

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public Night getNight() {
		return night;
	}

	public void setNight(Night night) {
		this.night = night;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Daily(String date, String week, String sunrise, String sunset, Night night, Day day) {
		super();
		this.date = date;
		this.week = week;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.night = night;
		this.day = day;
	}
	
	public Daily() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Daily [date=" + date + ", week=" + week + ", sunrise=" + sunrise + ", sunset=" + sunset + ", night="
				+ night + ", day=" + day + "]";
	}
	
	

}
