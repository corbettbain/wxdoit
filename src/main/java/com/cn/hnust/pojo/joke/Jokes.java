package com.cn.hnust.pojo.joke;

import java.util.List;

/**
* @author zn
* @version ����ʱ�䣺2017��2��10�� ����9:44:31
* ��˵��
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
	 * ��ȡ pagesize
	 * @return the pagesize pagesize
	 */
	public String getPagesize() {
		return pagesize;
	}
	/**
	 * ���� pagesize
	 * @param pagesize the pagesize to set pagesize
	 */
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * ��ȡ list
	 * @return the list list
	 */
	public List<Joke> getList() {
		return list;
	}
	/**
	 * ���� list
	 * @param list the list to set list
	 */
	public void setList(List<Joke> list) {
		this.list = list;
	}
	
	public Jokes() {
		// TODO Auto-generated constructor stub
	}
}
