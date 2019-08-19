package co.kkomang.app.view;

import java.io.IOException;

import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.service.NaverBookService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DAOtest extends Application{
	
	
	@Override
	public void  start(Stage primaryStage) {

		AnchorPane anc;
		try {
			anc = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(anc, 450, 800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		
//        for(BookInfoV b : NaverBookService.searchBook("d_titl", "너에게 닿기를", 30, 1))
//            System.out.println(b);
		launch(args);

	}

}
