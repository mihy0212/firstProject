package co.kkomang.app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {
	@FXML
	private BorderPane rootlayout;

private Stage primaryStage;

	public static void main(String[] args) {
		//launch 메소드는 메인 클래스의 객체를 생성하고 메인 윈도우를 생성 
		//그리고 start 메소드를 호출하면서 이 메인 윈도우를 매개값(Stage primaryStage)으로 전달
		launch(args);
	}

	@Override

	public void start(Stage primaryStage) throws Exception {
		//
		this.primaryStage = primaryStage;
		//FXMLLoader는 FXML 파일을 로딩하기 위하여 사용
		//getClass는 현재 클래스를 리턴해 주는 메소드
		//getResource 메소드는 클래스가 있는 곳에서 입력받은 URL을 리턴
		// 참조 변수 loader 안에 대입
		Parent root = FXMLLoader.load(getClass().getResource("view/FirstPage.fxml"));
		//Parent는 추상 클래스로, 화면을 구현하는 UI 컨트롤들이 추가되는 컨테이너
		//root 메소드로 입력된 Root.fxml 파일을 로딩하(쉽게 말하면 화면 정보를 로딩한 후 리턴한)
		//root 메소드 호출 시 예외 처리가 필요하여 start 메소드에 예외 떠넘기기(throws Exception)를 함
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);// setScene 메소드는 장면(Scene)을 윈도우에 올려주는 역할
		primaryStage.setResizable(false);
		primaryStage.show();//show 메소드는 설정된 윈도우 창을 화면에 띄워주는 역할
//		 showmemberView();
//		showLogView();
//		initRootLayout();
		//	home();
		Thread.sleep(2000);

	}

	public void showLogView() {
		try {
			AnchorPane logView = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
			Scene scene = new Scene(logView);
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
	
//
//	public void showmemberView() {
//		try {
//			AnchorPane memberView = FXMLLoader.load(getClass().getResource("view/members.fxml"));
//			Scene scene = new Scene(memberView);
//			primaryStage.setScene(scene);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// RootLayout
//	public void initRootLayout() {
//		try {
//			rootlayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
//			Scene scene = new Scene(rootlayout, 540, 900);
//			primaryStage.setTitle("HOME");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// home
//	public void home() {
//		try {
//			rootlayout = FXMLLoader.load(getClass().getResource("view/home.fxml"));
//			Scene scene = new Scene(rootlayout, 540, 960);
//			primaryStage.setTitle("HOME");
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}




