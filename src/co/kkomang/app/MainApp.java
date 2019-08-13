package co.kkomang.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
//FirstPage
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;//primaryStage 다시 선언
		Parent root = FXMLLoader.load(getClass().getResource("view/FirstPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);// Stage에 root.fxml를 load한 scene를 가지고 있음
		 primaryStage.setResizable(false);
		primaryStage.show();
//		 showmemberView();
		showLogView();
//	p	initRootLayout();
//		Thread.sleep(2000);

		 
	}

	public void showLogView() {
		try {
			AnchorPane logView = FXMLLoader.load(getClass().getResource("view/login.fxml"));
			Scene scene = new Scene(logView);
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void showmemberView() {
		try {
			AnchorPane memberView = FXMLLoader.load(getClass().getResource("view/members.fxml"));
			Scene scene = new Scene(memberView);
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// RootLayout
	public void initRootLayout() {
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("view/RootLayout.fxml"));
			Scene scene = new Scene(rootLayout, 540, 960);
			primaryStage.setTitle("HOME");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// home
		public void home() {
			try {
				rootLayout = FXMLLoader.load(getClass().getResource("view/home.fxml"));
				Scene scene = new Scene(rootLayout, 540, 960);
				primaryStage.setTitle("HOME");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
