package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.kkomang.app.common.DAO;
import co.kkomang.app.model.Users;
import co.kkomang.app.model.UsersV;

public class UserServiceImpl {
//입력받은 정보를 가지고 와서 DAO로 넘기는 클래스
	
	UserDAO userDAO = UserDAO.getInstance();
	int rsCode = 0;
	/*
	 * rsCode <결과 코드>
	 * 0 결과값이 넘어가지 않음
	 * 1 결과가 잘 넘어갔음
	 * -1 "이미 사용 중인 아이디입니다. 다른 아이디를 입력해 주세요."
	 * -2 "이미 등록된 이메일입니다. 다른 이메일을 입력해 주세요."
	 * -3 "해당하는 아이디가 없습니다."
	 * -9 DB 접속하지 못함.
	 */
	
	private static UserServiceImpl instance = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	//등록
	public int insert(Users user) {
		Connection conn = DAO.getConnect();
				try {
			conn.setAutoCommit(false);
			//아이디체크
			Users uid = userDAO.selectOneId(conn, user.getUserId());
			if(uid != null) {
				rsCode = -1;
				System.out.println("이미 사용 중인 아이디입니다. 다른 아이디를 입력해 주세요.");//추후 주석처리
				return rsCode;
			}
			//이메일체크
			Users userResult2 = userDAO.selectOneEmail(conn, user.getEmail());
			if(userResult2 != null) {
				rsCode = -2;
				System.out.println("이미 등록된 이메일입니다. 다른 이메일을 입력해 주세요.");//추후 주석처리
				return rsCode;
			}
			userDAO.insert(conn, user);
			rsCode = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
	}
	
	//수정
	public int update(Users user) {
		Connection conn = DAO.getConnect();
		try {
			conn.setAutoCommit(false); 
			//이메일 체크
			Users uemail = userDAO.selectOneEmail(conn, user.getEmail()); //이메일 중복체크
			if(uemail != null ) {
				rsCode = -2;
				System.out.println("이미 등록된 이메일입니다. 다른 이메일을 입력해주세요.");//추후 주석처리
			}
			userDAO.update(conn, user);
			rsCode = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
	}
	
	//삭제
	public int delete(String userId) {
		Connection conn = DAO.getConnect();
		try {
			conn.setAutoCommit(false);
			//아이디 체크
			Users uid = userDAO.selectOneId(conn, userId);
			if(uid == null) {
				rsCode = -3;
				System.out.println("삭제할 아이디가 없습니다.");
				return rsCode;
			}
			userDAO.delete(conn, userId);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
	}
	
	//한건 조회
	public Users selectOne(String userId) {
		Connection conn = DAO.getConnect();
		try {
			return userDAO.selectOneId(conn, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
	}
	
	//전체 조회
	public List<Users> selectAll() {
		Connection conn = DAO.getConnect();
		List<Users> list = null;
		try {
			list = userDAO.selectAll(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	//View를 위한 한건 조회
	public UsersV selectOneV(String userId) {
		Connection conn = DAO.getConnect();
		try {
			return userDAO.selectOneV(conn, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
	}
	
	//View를 위한 전체 조회
	public List<UsersV> selectAllV() {
		Connection conn = DAO.getConnect();
		List<UsersV> list = null;
		try {
			list = userDAO.selectAllV(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
		return list;
	}
}
