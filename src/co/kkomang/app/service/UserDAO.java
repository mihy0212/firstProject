package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.kkomang.app.model.Users;
import co.kkomang.app.model.UsersV;

public class UserDAO {

	//싱글톤
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	//등록
	public void insert(Connection conn, Users user) throws SQLException {
		String sql = "insert into users(user_id, passwd,"
				+ " email, phone_num, nick_name, age, sex)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPasswd());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getPhoneNum());
		pstmt.setString(5, user.getNickName());
		pstmt.setInt(6, user.getAge());
		pstmt.setInt(7, user.getSex());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 등록 완료");
	}
	
	//수정
	public void update(Connection conn, Users user) throws SQLException {
		String sql = "update users set userpw=?,"
				+ " email=?, phone_num=?, nick_name=?,"
				+ " age=?, sex=?"
				+ " where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPasswd());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPhoneNum());
		pstmt.setString(4, user.getNickName());
		pstmt.setInt(5, user.getAge());
		pstmt.setInt(6, user.getSex());
		pstmt.setString(7, user.getUserId());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 수정 완료");
	}
	
	//삭제
	public void delete(Connection conn, String user_id) throws SQLException {
		String sql = "delete from users where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 삭제 완료");
	}
	
	//한건 조회
	public Users selectOne(Connection conn, String user_id) throws SQLException {
		Users user = null;
		String sql = "select user_id, userpw,"
				+ " email, phone_num, nick_name,"
				+ " age, sex from users"
				+ " where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new Users();
			user.setUserId(rs.getString("user_id"));
			user.setPasswd(rs.getString("userpw"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNum(rs.getString("phone_num"));
			user.setNickName(rs.getString("nick_name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
		}
		return user;
	}
	
	//전체조회
	public List<Users> selectAll(Connection conn) throws SQLException{
		List<Users> list = new ArrayList<>();
		String sql = "select user_id, userpw,"
				+ " email, phone_num, nick_name,"
				+ " age, sex from users order by 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Users user = new Users();
			user.setUserId(rs.getString("user_id"));
			user.setPasswd(rs.getString("userpw"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNum(rs.getString("phone_num"));
			user.setNickName(rs.getString("nick_name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
			list.add(user);
		}
		return list;
	}
	
	
	//UserV
	//한건 조회
	public UsersV selectOneV(Connection conn, String user_id) throws SQLException {
		UsersV userV = null;
		String sql = "select user_id, userpw,"
				+ " email, phone_num, nick_name,"
				+ " age, sex from users"
				+ " where user_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			userV = new UsersV();
			userV.setUserId(rs.getString("user_id"));
			userV.setPasswd(rs.getString("userpw"));
			userV.setEmail(rs.getString("email"));
			userV.setPhoneNum(rs.getString("phone_num"));
			userV.setNickName(rs.getString("nick_name"));
			userV.setAge(rs.getInt("age"));
			userV.setSex(rs.getInt("sex"));
		}
		return userV;
	}
	
	//전체조회
	public List<UsersV> selectAllV(Connection conn) throws SQLException{
		List<UsersV> list = new ArrayList<>();
		String sql = "select user_id, userpw,"
				+ " email, phone_num, nick_name,"
				+ " age, sex from users order by 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			UsersV userV = new UsersV();
			userV.setUserId(rs.getString("user_id"));
			userV.setPasswd(rs.getString("userpw"));
			userV.setEmail(rs.getString("email"));
			userV.setPhoneNum(rs.getString("phone_num"));
			userV.setNickName(rs.getString("nick_name"));
			userV.setAge(rs.getInt("age"));
			userV.setSex(rs.getInt("sex"));
			list.add(userV);
		}
		return list;
	}
	
}
