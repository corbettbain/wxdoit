package com.cn.hnust.pojo.weather;
/**
* @author zn
* @version 创建时间：2017年2月9日 下午7:23:42
* 类说明
*/
public class WeatherResult {

	private String status;
	private String msg;
	private WeathersForDays result;
	/**
	 * 获取 status
	 * @return the status status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置 status
	 * @param status the status to set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取 msg
	 * @return the msg msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置 msg
	 * @param msg the msg to set msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取 result
	 * @return the result result
	 */
	public WeathersForDays getResult() {
		return result;
	}
	/**
	 * 设置 result
	 * @param result the result to set result
	 */
	public void setResult(WeathersForDays result) {
		this.result = result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeatherResult [status=" + status + ", msg=" + msg + ", result=" + result + "]";
	}
	/**
	 * @param status
	 * @param msg
	 * @param result
	 */
	public WeatherResult(String status, String msg, WeathersForDays result) {
		super();
		this.status = status;
		this.msg = msg;
		this.result = result;
	}
	
	
	public WeatherResult() {
		// TODO Auto-generated constructor stub
	}
	
}
