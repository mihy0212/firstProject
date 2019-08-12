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
	private AnchorPane layout;
	private BorderPane rootLayout;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
//FirstPage
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		layout = FXMLLoader.load(getClass().getResource("view/FirstPage.fxml"));
		Scene scene = new Scene(layout);
		primaryStage.setTitle("FIRST");
		primaryStage.setScene(scene);// Stage에 root.fxml를 load한 scene를 가지고 있음
		primaryStage.show();

//		showLogView();
		initRootLayout();
//		Thread.sleep(2000);
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
	
	// RootLayout
		public void home() {
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

}
