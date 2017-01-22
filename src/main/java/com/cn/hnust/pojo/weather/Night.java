package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��19�� ����7:26:20 ��˵��:���ϵ�����
 */
public class Night {

	private String weather;
	
	private String templow;//����¶�
	
	private String img;
	
	private String winddirect;//����
	
	private String windpower;//����

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemplow() {
		return templow;
	}

	public void setTemplow(String templow) {
		this.templow = templow;
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
	
	public Night() {
		// TODO Auto-generated constructor stub
	}

	public Night(String weather, String templow, String img, String winddirect, String windpower) {
		super();
		this.weather = weather;
		this.templow = templow;
		this.img = img;
		this.winddirect = winddirect;
		this.windpower = windpower;
	}

	@Override
	public String toString() {
		return "Day [weather=" + weather + ", templow=" + templow + ", img=" + img + ", winddirect=" + winddirect
				+ ", windpower=" + windpower + "]";
	}
	
}
