package co.kkomang.app.model;

public class Users {

	private String userId;
	private String passwd;
	private String email;
	private String nickName;
	private int age;
	private int sex;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", passwd=" + passwd + ", email=" + email + ", nickName=" + nickName
				+ ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
}
