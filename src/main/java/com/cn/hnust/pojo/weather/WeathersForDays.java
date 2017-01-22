package com.cn.hnust.pojo.weather;

import java.util.Date;
import java.util.List;;

/**
* @author zn
* @version ����ʱ�䣺2017��1��17�� ����10:00:06
* ��˵��
*/
/**
 * @author zn 2017��1��19��
 *
 */
public class WeathersForDays {

	private String city;
	
	private String cityid;
	
	private String citycode;
		
	private Date date;
	
	private String week;

	private String weather;

	private String temp;
	
	private String temphigh;
	
	private String templow;
	
	private String img;
	/**
	 * ʪ��
	 */
	private String humidity;
	/**
	 * ѹǿ
	 */
	private String pressure;
	/**
	 * ����
	 */
	private String windspeed;
	/**
	 * ����
	 */
	private String winddirect;
	/**
	 * ����
	 */
	private String windpower;
	
	private String updatetime;
	
	private List<Hourly> hourly;
	
	private List<Daily> daily;
	
	private List<Index> index;
	/**
	 *@param ����ָ��
	 */
	private List<Aqi> aqi;

	
	/**
	 * ��ȡ citycode
	 * @return the citycode citycode
	 */
	public String getCitycode() {
		return citycode;
	}

	/**
	 * ���� citycode
	 * @param citycode the citycode to set citycode
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
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

	public String getTemphigh() {
		return temphigh;
	}

	public void setTemphigh(String temphigh) {
		this.temphigh = temphigh;
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

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
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

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public List<Hourly> getHourly() {
		return hourly;
	}

	public void setHourly(List<Hourly> hourly) {
		this.hourly = hourly;
	}

	public List<Daily> getDaily() {
		return daily;
	}

	public void setDaily(List<Daily> daily) {
		this.daily = daily;
	}

	public List<Index> getIndex() {
		return index;
	}

	public void setIndex(List<Index> index) {
		this.index = index;
	}

	/**
	 * ��ȡ aqi
	 * @return the aqi aqi
	 */
	public List<Aqi> getAqi() {
		return aqi;
	}

	/**
	 * ���� aqi
	 * @param aqi the aqi to set aqi
	 */
	public void setAqi(List<Aqi> aqi) {
		this.aqi = aqi;
	}

	
	
}
