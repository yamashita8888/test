package web;

import java.io.Serializable;

public class logicBean implements Serializable  {
	static final long serialVersionUID = 1L;
	private int user_id;
	private String user_name;
	private String login_cd;
	private String login_pw;

	/**
	 * @return userId
	 */
	public int getUserId() {
		return user_id;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.user_id = userId;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return user_name;
	}
	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.user_name = userName;
	}
	/**
	 * @return loginCd
	 */
	public String getLoginCd() {
		return login_cd;
	}
	/**
	 * @param loginCd セットする loginCd
	 */
	public void setLoginCd(String loginCd) {
		this.login_cd = loginCd;
	}
	/**
	 * @return loginPw
	 */
	public String getLoginPw() {
		return login_pw;
	}
	/**
	 * @param loginPw セットする loginPw
	 */
	public void setLoginPw(String loginPw) {
		this.login_pw = loginPw;
	}

}