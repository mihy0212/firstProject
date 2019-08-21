package co.kkomang.app.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DAO {
	
	public static Connection getConnect() {
		
		Properties prop = new Properties();
		String path = PropertiesExample.class.getResource("config/database.properties").getPath(); //database의 위치를 얻어오는 방법.
		try {
			path = URLDecoder.decode(path, "utf=8");
			prop.load(new FileReader(path));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driver = prop.getProperty("driver");//database.properties의 파일을 읽어와서 driver값을 가져오는 것
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pw = prop.getProperty("passwd"); //이렇게 각각의 키값을 파일에서 받아 변수에 받음.
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
