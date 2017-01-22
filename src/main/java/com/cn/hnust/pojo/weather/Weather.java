package com.cn.hnust.pojo.weather;
/**
* @author zn
* @version 创建时间：2017年1月17日 下午9:31:46
* 类说明
*/
public class Weather {

	private String fengxiang;
	
	private String fengli;

	private String high;
	
	private String type;
	
	private String low;
	
	private String date;

	public String getFengxiang() {
		return fengxiang;
	}

	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}

	public String getFengli() {
		return fengli;
	}

	public void setFengli(String fengli) {
		this.fengli = fengli;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Weather [fengxiang=" + fengxiang + ", fengli=" + fengli + ", high=" + high + ", type=" + type + ", low="
				+ low + ", date=" + date + "]";
	}

	public Weather(String fengxiang, String fengli, String high, String type, String low, String date) {
		super();
		this.fengxiang = fengxiang;
		this.fengli = fengli;
		this.high = high;
		this.type = type;
		this.low = low;
		this.date = date;
	}
	
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	
}
