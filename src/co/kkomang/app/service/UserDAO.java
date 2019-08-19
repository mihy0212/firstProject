package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.kkomang.app.model.Users;
import co.kkomang.app.model.UsersV;

public class UserDAO {

	PreparedStatement pstmt;
	ResultSet rs;
	
	//싱글톤
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	
	//등록
	public void insert(Connection conn, Users user) throws SQLException {
		String sql = "insert into users(user_id, passwd,"
				+ " email, nick_name, age, sex)"
				+ " values(?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPasswd());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getNickName());
		pstmt.setInt(5, user.getAge());
		pstmt.setInt(6, user.getSex());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 등록 완료");
	}
	
	//수정
	public void update(Connection conn, Users user) throws SQLException {
		String sql = "update users set passwd=?,"
				+ " email=?, nick_name=?,"
				+ " age=?, sex=?"
				+ " where user_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getPasswd());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getNickName());
		pstmt.setInt(4, user.getAge());
		pstmt.setInt(5, user.getSex());
		pstmt.setString(6, user.getUserId());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 수정 완료");
	}
	
	//삭제
	public void delete(Connection conn, String userId) throws SQLException {
		String sql = "delete from users where user_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 삭제 완료");
	}
	
	//한건 조회 : 유저 아이디로 조회
	public Users selectOneId(Connection conn, String userId) throws SQLException {
		Users user = null;
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex"
				+ " from users"
				+ " where user_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new Users();
			user.setUserId(rs.getString("user_id"));
			user.setPasswd(rs.getString("passwd"));
			user.setEmail(rs.getString("email"));
			user.setNickName(rs.getString("nick_name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
		}
		return user;
	}
	
	//한건 조회: 아이디와 비밀번호 필요(로그인)
	public Users login(Connection conn, String userId, String passwd) throws SQLException {
		Users user = null;
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex"
				+ " from users"
				+ " where user_id=? and passwd=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, passwd);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new Users();
			user.setUserId(rs.getString("user_id"));
			user.setPasswd(rs.getString("passwd"));
			user.setEmail(rs.getString("email"));
			user.setNickName(rs.getString("nick_name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
		}
		return user;
	}
	
	//한건 조회 : 이메일로 조회
	public Users selectOneEmail(Connection conn, String email) throws SQLException {
		Users user = null;
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex from users"
				+ " where email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			user = new Users();
			user.setUserId(rs.getString("user_id"));
		}
		return user;
	}
	
	//전체조회
	public List<Users> selectAll(Connection conn) throws SQLException{
		List<Users> list = new ArrayList<>();
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex from users order by 1";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Users user = new Users();
			user.setUserId(rs.getString("user_id"));
			user.setPasswd(rs.getString("passwd"));
			user.setEmail(rs.getString("email"));
			user.setNickName(rs.getString("nick_name"));
			user.setAge(rs.getInt("age"));
			user.setSex(rs.getInt("sex"));
			list.add(user);
		}
		return list;
	}
	
	
	//View를 위한 한건 조회
	public UsersV selectOneV(Connection conn, String user_id) throws SQLException {
		UsersV userV = null;
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex from users"
				+ " where user_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			userV = new UsersV();
			userV.setUserId(rs.getString("user_id"));
			userV.setPasswd(rs.getString("passwd"));
			userV.setEmail(rs.getString("email"));
			userV.setNickName(rs.getString("nick_name"));
			userV.setAge(rs.getInt("age"));
			userV.setSex(rs.getInt("sex"));
		}
		return userV;
	}
	
	
	
	//View를 위한 전체 조회
	public List<UsersV> selectAllV(Connection conn) throws SQLException{
		List<UsersV> list = new ArrayList<>();
		String sql = "select user_id, passwd,"
				+ " email, nick_name,"
				+ " age, sex from users order by 1";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			UsersV userV = new UsersV();
			userV.setUserId(rs.getString("user_id"));
			userV.setPasswd(rs.getString("passwd"));
			userV.setEmail(rs.getString("email"));
			userV.setNickName(rs.getString("nick_name"));
			userV.setAge(rs.getInt("age"));
			userV.setSex(rs.getInt("sex"));
			list.add(userV);
		}
		return list;
	}
	
	//DTO없이 조회하기
	public List<Map<String, Object>> selectAllMap(Connection conn){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			String sql = "select * from users order by 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userId", rs.getString("user_id"));
				map.put("passwd", rs.getString("passwd"));
				map.put("email", rs.getString("email"));
				map.put("nickName", rs.getString("nick_name"));
				map.put("age", rs.getString("age"));
				map.put("sex", rs.getString("sex"));
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
