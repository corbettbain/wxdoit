package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version 创建时间：2017年1月19日 下午8:13:13 类说明:几项指数描述  例如 紫外线指数etc...
 */
public class Index {

	/**
	 * 指数名称
	 */
	private String iname;
	/**
	 * 建议
	 */
	private String ivalue;
	/**
	 * 指数描述和建议
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
