package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��19�� ����7:25:32 ��˵��:һ�������,��Ϊ���������
 */
public class Daily {

	private String date;//����
	
	private String week;//����
	
	private String sunrise;//�ճ�
	
	private String sunset;//����
	
	private Night night;//��������
	
	private Day day;//��������

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
