package com.cn.hnust.pojo;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��18�� ����1:23:55 ��˵��:����ʱ��ε��������
 */
public class Hourly {

	private String time;//ʱ��
	
	private String weather;//����
	
	private String temp;
	
	private String img;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	public Hourly() {
		// TODO Auto-generated constructor stub
	}

	public Hourly(String time, String weather, String temp, String img) {
		super();
		this.time = time;
		this.weather = weather;
		this.temp = temp;
		this.img = img;
	}

	@Override
	public String toString() {
		return "Hourly [time=" + time + ", weather=" + weather + ", temp=" + temp + ", img=" + img + "]";
	}
	
	
	
	
}
