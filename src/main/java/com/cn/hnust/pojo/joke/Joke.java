package com.cn.hnust.pojo.joke;

/**
* @author zn
* @version ����ʱ�䣺2017��2��10�� ����9:45:47
* ��˵��
*/
public class Joke {

	private Integer id;
	private String content;
	private String pic;
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
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
