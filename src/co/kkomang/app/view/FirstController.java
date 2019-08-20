package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstController implements Initializable {
	@FXML
	private Button startbtn;
	@FXML
	private AnchorPane first;
	

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		startbtn.setOnAction(event -> StartAction(event));
	}

	public void StartAction(ActionEvent event) {

		try {
			Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) startbtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
