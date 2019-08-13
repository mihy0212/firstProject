package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable{
	@FXML
	private AnchorPane Login;
    @FXML private TextField id;
    @FXML private PasswordField pwd;
    @FXML private Button membersBtn;
    @FXML private Button login;
    @FXML private Button exit;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		membersBtn.setOnAction(e->membersAction(e));
	}
    
	
	public void membersAction(ActionEvent event){
		try{
		Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));
		AnchorPane root = (AnchorPane) membersBtn.getScene().getRoot();
		root.getChildren().add(members);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void handleBtnAction(ActionEvent e){
		Platform.exit();
	}
	
}
