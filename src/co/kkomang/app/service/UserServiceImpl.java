package co.kkomang.app.service;

import java.sql.Connection;

import co.kkomang.app.common.DAO;
import co.kkomang.app.model.Users;

public class UserServiceImpl {
	
	UserDAO userDAO = UserDAO.getInstance();
	
	private static UserServiceImpl instance = new UserServiceImpl();
	public static UserServiceImpl getInstance() {
		return instance;
	}
	
	//등록
//	public boolean insert(Users user) {
//		Connection conn = DAO.getConnect();
//		
//	}

}
