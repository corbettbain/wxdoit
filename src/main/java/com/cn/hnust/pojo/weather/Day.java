package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��19�� ����7:26:58 ��˵��:���������
 */
public class Day {

	private String weather;

	private String temphigh;// ����¶�

	private String img;

	private String winddirect;// ����

	private String windpower;// ����

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
