package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��19�� ����8:04:06 ��˵��:��������ָ����Air Quality Index�����AQI���Ƕ���������������״����������ָ����----����
 */
public class Aqinfo {

	/**
	 * ���������ȼ�
	 */
	private String level;
	/**
	 * ��������ͼ����ɫ
	 */
	private String color;
	/**
	 * ������������
	 */
	private String affect;
	/**
	 * ��������ע������
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
