package co.kkomang.app.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyPageControler {
	
	@FXML
	private Button btnLogout;
	
	public void logoutAction(ActionEvent event) {
			try {
		Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
		Scene scene = new Scene(login);
		Stage primaryStage = (Stage) btnLogout.getScene().getWindow();
		primaryStage.setScene(scene);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	


}
