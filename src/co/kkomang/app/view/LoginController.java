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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	private AnchorPane login;
	@FXML
	private Label lblStatus;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button membersBtn;

	public void Login(ActionEvent event) throws Exception {
		membersBtn.setGraphic(new ImageView("viw/login.png"));
		if (txtUserName.getText().equals("userId") && txtPassword.getText().equals("passwd")) {
			lblStatus.setText("Login Success");
			Stage primaryStage = new Stage();// userName 과 password 가 일치하면 새로운 stage 가 생성
			Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("btn.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			lblStatus.setText("Login Failed");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		membersBtn.setOnAction(e -> membersAction(e));
	}

//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
////		member.setOnAction(e->membersAction(e));
//	}
//    
//	
	public void membersAction(ActionEvent event) {
		try {
			Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));
			AnchorPane root = (AnchorPane) members.getScene().getRoot();
			root.getChildren().add(members);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
