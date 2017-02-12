package com.cn.hnust.pojo.joke;

/**
* @author zn
* @version 创建时间：2017年2月10日 上午9:45:47
* 类说明
*/
public class Joke {

	private Integer id;
	private String content;
	private String pic;
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
