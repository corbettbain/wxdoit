package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version 创建时间：2017年1月19日 下午7:26:58 类说明:白天的天气
 */
public class Day {

	private String weather;

	private String temphigh;// 最低温度

	private String img;

	private String winddirect;// 风向

	private String windpower;// 风力

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemphigh() {
		return temphigh;
	}

	public void setTemphigh(String temphigh) {
		this.temphigh = temphigh;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getWinddirect() {
		return winddirect;
	}

	public void setWinddirect(String winddirect) {
		this.winddirect = winddirect;
	}

	public String getWindpower() {
		return windpower;
	}

	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}

	public Day() {
		// TODO Auto-generated constructor stub
	}

	public Day(String weather, String temphigh, String img, String winddirect, String windpower) {
		super();
		this.weather = weather;
		this.temphigh = temphigh;
		this.img = img;
		this.winddirect = winddirect;
		this.windpower = windpower;
	}

	@Override
	public String toString() {
		return "Day [weather=" + weather + ", temphigh=" + temphigh + ", img=" + img + ", winddirect=" + winddirect
				+ ", windpower=" + windpower + "]";
	}

}
