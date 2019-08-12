package co.kkomang.app.common;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesExample {
//외부파일 불러와서 실행시키기
	
	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		String path = PropertiesExample.class.getResource("/config/database.properties").getPath();
		path = URLDecoder.decode(path, "utf=8");
		prop.load(new FileReader(path));
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String passwd = prop.getProperty("passwd");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(passwd);
	}
	
}
