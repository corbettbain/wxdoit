package com.cn.hnust.pojo.joke;

/**
* @author zn
* @version ����ʱ�䣺2017��2��10�� ����9:45:47
* ��˵��
*/
public class Joke {

	private String content;
	private String addtime;
	private String url;
	/**
	 * ��ȡ content
	 * @return the content content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * ���� content
	 * @param content the content to set content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * ��ȡ addtime
	 * @return the addtime addtime
	 */
	public String getAddtime() {
		return addtime;
	}
	/**
	 * ���� addtime
	 * @param addtime the addtime to set addtime
	 */
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	/**
	 * ��ȡ url
	 * @return the url url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * ���� url
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
