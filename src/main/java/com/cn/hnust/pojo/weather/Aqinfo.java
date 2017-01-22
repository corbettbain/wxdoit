package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version 创建时间：2017年1月19日 下午8:04:06 类说明:空气质量指数（Air Quality Index，简称AQI）是定量描述空气质量状况的无量纲指数。----详情
 */
public class Aqinfo {

	/**
	 * 空气质量等级
	 */
	private String level;
	/**
	 * 空气质量图形颜色
	 */
	private String color;
	/**
	 * 空气质量描述
	 */
	private String affect;
	/**
	 * 空气质量注意事项
	 */
	private String measure;
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAffect() {
		return affect;
	}
	public void setAffect(String affect) {
		this.affect = affect;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}

	
}
