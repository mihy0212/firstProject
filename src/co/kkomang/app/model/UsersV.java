package co.kkomang.app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UsersV {
	
	private StringProperty userId;
	private StringProperty passwd;
	private StringProperty email;
	private StringProperty phoneNum;
	private StringProperty nickName;
	private IntegerProperty age;
	private IntegerProperty sex;
	
	//생성자
	public UsersV() {
		userId = new SimpleStringProperty();
		passwd = new SimpleStringProperty();
		email = new SimpleStringProperty();
		phoneNum = new SimpleStringProperty();
		nickName = new SimpleStringProperty();
		age = new SimpleIntegerProperty();
		sex = new SimpleIntegerProperty();
	}
	
	//property 넘겨주는 메서드
	public StringProperty userIdProperty() {
		return userId;
	}
	public StringProperty passwdProperty() {
		return passwd;
	}
	public StringProperty emailProperty() {
		return email;
	}
	public StringProperty phoneNumProperty() {
		return phoneNum;
	}
	public StringProperty nickNameProperty() {
		return nickName;
	}
	public IntegerProperty ageProperty() {
		return age;
	}
	public IntegerProperty sexProperty() {
		return sex;
	}
	
	
	//getter
	public String getUserId() {
		return userId.get();
	}

	public String getPasswd() {
		return passwd.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getPhoneNum() {
		return phoneNum.get();
	}

	public String getNickName() {
		return nickName.get();
	}

	public Integer getAge() {
		return age.get();
	}

	public Integer getSex() {
		return sex.get();
	}
	
	
	//setter
	public void setUserId(String userId) {
		this.userId.set(userId);
	}

	public void setPasswd(String passwd) {
		this.passwd.set(passwd);
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum.set(phoneNum);
	}

	public void setNickName(String nickName) {
		this.nickName.set(nickName);
	}

	public void setAge(Integer age) {
		this.age.set(age);
	}

	public void setSex(Integer sex) {
		this.sex.set(sex);
	}
	

}
