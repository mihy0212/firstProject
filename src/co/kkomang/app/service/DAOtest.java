package co.kkomang.app.service;

import java.io.IOException;
import java.util.List;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.model.Users;
import co.kkomang.app.model.UsersV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DAOtest{

	
	public static void main(String[] args) {
		
		
		Users user = new Users();
		UsersV userv = new UsersV();
		UserServiceImpl uService = new UserServiceImpl();
		
//		user.setUserId("112");
//		user.setPasswd("aaa");
//		user.setEmail("a2g@aaa.net");
//		user.setNickName("aaa");
//		user.setAge(27);
//		user.setSex(1);
//		uService.insert(user);
//		
//		uService.delete("bbb");
		
//		user.setUserId("112");
//		user.setPasswd("bbb");
//		user.setEmail("a2g@aaa.net");
//		user.setNickName("aaa");
//		user.setAge(27);
//		user.setSex(2);
//		uService.update(user);
		
//		List<Users> list = uService.selectAll();
//		for(Users sss : list) {
//			System.out.println(sss);
//		}
//		List<UsersV> listv = uService.selectAllV();
//		for(UsersV ddd : listv) {
//			System.out.println(ddd);
//		}
//		Users a = uService.selectOne("111");
//		System.out.println(a);
//		
//		a = uService.login("vvv", "aaa");
//		System.out.println(a);
		
//		UsersV b = uService.selectOneV("112");
//		System.out.println(b);
//		
	
//		BookInfo book = new BookInfo();
//		BookInfoV bookv = new BookInfoV();
//		BookServiceImpl bService = new BookServiceImpl();
		
//		book.setIsbn(44444);
//		book.setTitle("ㅁㄴㅇㄻㄴㅇㄹ");
//		book.setAuthor("Author");
//		book.setCategory(1);
//		book.setChoiceWhere(1);
//		book.setDescription("description");
//		book.setDiscount(2500);
//		book.setImage(null);
//		book.setMemo("memo");
//		book.setPrice(3000);
//		book.setPrivateMemo(0);
//		book.setPubdate("1995/02/02");
//		book.setReadDate("2019/01/01");
//		book.setPublisher("나나");
//		book.setReading(1);
//		book.setStar(5);
//		bService.insert(book);
//		bService.update(book);
//		bService.delete();
		
//		List<BookInfoV> list = bService.selectAllV();
//		for(BookInfoV a : list) {
//			System.out.println(a);
//		}
		
		//네이버 조회(static으로 저장했음.
//		for(BookInfoV b : NaverBookService.searchBook("너에게 닿기를", "query", 20, 1)) {
//			System.out.println(b);
//		}
		
		//조회한 내용 저장
		
		
	}

}
