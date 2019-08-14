package co.kkomang.app.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import co.kkomang.app.model.Users;
import co.kkomang.app.model.UsersV;
import co.kkomang.app.service.UserServiceImpl;
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
import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.PasswordField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	@FXML
	private Button loginBtn;

	public void Login(ActionEvent event) throws SQLException {
		Users user = new Users();
		UsersV userv = new UsersV();
		UserServiceImpl uService = new UserServiceImpl();
//		membersBtn.setGraphic(new ImageView("viw/login.png"));
		if (txtUserName.getText().equals(uService.selectOne(txtUserName.getText())) && txtPassword.getText().equals((uService.selectOne(txtPassword.getText())))) {
			lblStatus.setText("Login Success");
			Stage primaryStage = new Stage();// userName 과 password 가 일치하면 새로운 stage 가 생성
			Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("home.fxml"));
				Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("btn.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			lblStatus.setText("Login Failed");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		membersBtn.setOnAction(e -> membersAction(e));
	}


	public void membersAction(ActionEvent event) {
		try {
			Stage mem = new Stage(StageStyle.UTILITY);
			mem.initModality(Modality.WINDOW_MODAL);
			mem.initOwner(membersBtn.getScene().getWindow());	
			Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));
			Scene scene = new Scene(members);
			mem.setScene(scene);
			mem.setResizable(false);
			mem.show();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
