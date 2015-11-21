package sample.mybatis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * User实体类，将同时用于Mybatis和JPA使用
 *
 * @author 小翼
 * @version 1.0.0
 */
@Entity
public class User {
	@Id
	private String username;
	private String userpwd;
	private int uid;

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", userpwd='" + userpwd + '\'' +
				", uid=" + uid +
				'}';
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
