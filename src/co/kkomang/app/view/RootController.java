package co.kkomang.app.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

	@FXML BorderPane borderPane; 
	@FXML ImageView home;
	@FXML ImageView search;
	@FXML ImageView mypage;
	@FXML Button btnHome;
	@FXML Button btnSearch;
	@FXML Button btnMy;
	
	private Executor exec;
	boolean roop = true;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exec = Executors.newCachedThreadPool((runnable) -> { //newCachedThreadPool로 스레드풀을 만듦
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});
		
		AnchorPane homeView;
		try {
			homeView = FXMLLoader.load(getClass().getResource("Home.fxml"));
			borderPane.setCenter(homeView);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@FXML
	public void handleHome(ActionEvent actionEvent) { 
		try {
			AnchorPane homeView = 
					FXMLLoader.load(getClass().getResource("Home.fxml"));
			borderPane.setCenter(homeView);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void handleSearch(ActionEvent actionEvent) { 
		try {
			AnchorPane searchView = 
					FXMLLoader.load(getClass().getResource("Search.fxml"));
			borderPane.setCenter(searchView);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@FXML
	public void handleMy(ActionEvent actionEvent) { 
		try {
			AnchorPane mypageView = 
					FXMLLoader.load(getClass().getResource("Mypage.fxml"));
			borderPane.setCenter(mypageView);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
//	@FXML
//	public void handleMypage(ActionEvent actionEvent) { //무조건 온액션인 것은 아님. 우리는 버튼형이라서 온액션을 쓰고 있음. 키보드 이벤트면 keyEvent여야 하고, mouse무스 이벤트면 mouseMotion 등이 따로 있음.
//		try {
//			AnchorPane mypageView = 
//					FXMLLoader.load(getClass().getResource(""));
//			borderPane.setCenter(mypageView);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	
	
}
