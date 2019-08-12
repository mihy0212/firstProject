package co.kkomang.app.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		initRootLayout();
		showDeptView();
	}


	public void initRootLayout() {
	try {
			rootLayout  = FXMLLoader.load(getClass().getResource("view/RootView.fxml"));
			Scene scene = new Scene(rootLayout, 700, 420);
			primaryStage.setTitle("scene");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showDeptView() {
		try {
			AnchorPane deptView = 
			FXMLLoader.load(getClass().getResource("view/DeptFxml.fxml"));
			rootLayout.setCenter(deptView);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
//		new DeptFrame();
	}
}
