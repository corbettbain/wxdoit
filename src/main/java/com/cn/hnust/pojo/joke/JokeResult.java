package com.cn.hnust.pojo.joke;
/**
* @author zn
* @version ����ʱ�䣺2017��2��9�� ����7:32:03
* ��˵��
*/
public class JokeResult {

	public static final String STRURL = "http://api.jisuapi.com/xiaohua/all";
	
	private String status;
	private String msg;
	private Jokes result;
	/**
	 * ��ȡ status
	 * @return the status status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * ���� status
	 * @param status the status to set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * ��ȡ msg
	 * @return the msg msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * ���� msg
	 * @param msg the msg to set msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * ��ȡ result
	 * @return the result result
	 */
	public Jokes getResult() {
		return result;
	}
	/**
	 * ���� result
	 * @param result the result to set result
	 */
	public void setResult(Jokes result) {
		this.result = result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JokeResult [status=" + status + ", msg=" + msg + ", result=" + result + "]";
	}
	/**
	 * @param status
	 * @param msg
	 * @param result
	 */
	public JokeResult(String status, String msg, Jokes result) {
		super();
		this.status = status;
		this.msg = msg;
		this.result = result;
	}
	
	public JokeResult() {
		// TODO Auto-generated constructor stub
	}
}
