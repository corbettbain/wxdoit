package com.cn.hnust.pojo.joke;

import java.util.List;

/**
* @author zn
* @version 创建时间：2017年2月10日 上午9:44:31
* 类说明
*/
public class Jokes {

	private String total;
	private String pagenum;
	private String pagesize;
	private List<Joke> list;
	
	
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	/**
	 * 获取 pagesize
	 * @return the pagesize pagesize
	 */
	public String getPagesize() {
		return pagesize;
	}
	/**
	 * 设置 pagesize
	 * @param pagesize the pagesize to set pagesize
	 */
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * 获取 list
	 * @return the list list
	 */
	public List<Joke> getList() {
		return list;
	}
	/**
	 * 设置 list
	 * @param list the list to set list
	 */
	public void setList(List<Joke> list) {
		this.list = list;
	}
	
	public Jokes() {
		// TODO Auto-generated constructor stub
	}
}
