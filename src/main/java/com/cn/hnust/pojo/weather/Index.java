package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��19�� ����8:13:13 ��˵��:����ָ������  ���� ������ָ��etc...
 */
public class Index {

	/**
	 * ָ������
	 */
	private String iname;
	/**
	 * ����
	 */
	private String ivalue;
	/**
	 * ָ�������ͽ���
	 */
	private String detail;
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIvalue() {
		return ivalue;
	}
	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Index(String iname, String ivalue, String detail) {
		super();
		this.iname = iname;
		this.ivalue = ivalue;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Index [iname=" + iname + ", ivalue=" + ivalue + ", detail=" + detail + "]";
	}

	public Index() {
		// TODO Auto-generated constructor stub
	}
}
