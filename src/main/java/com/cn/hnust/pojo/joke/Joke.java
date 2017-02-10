package com.cn.hnust.pojo.joke;

/**
* @author zn
* @version 创建时间：2017年2月10日 上午9:45:47
* 类说明
*/
public class Joke {

	private String content;
	private String addtime;
	private String url;
	/**
	 * 获取 content
	 * @return the content content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置 content
	 * @param content the content to set content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取 addtime
	 * @return the addtime addtime
	 */
	public String getAddtime() {
		return addtime;
	}
	/**
	 * 设置 addtime
	 * @param addtime the addtime to set addtime
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取 url
	 * @return the url url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置 url
	 * @param url the url to set url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param content
	 * @param addtime
	 * @param url
	 */
	public Joke(String content, String addtime, String url) {
		super();
		this.content = content;
		this.addtime = addtime;
		this.url = url;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Joke [content=" + content + ", addtime=" + addtime + ", url=" + url + "]";
	}
	
	public Joke() {
		// TODO Auto-generated constructor stub
	}
}
