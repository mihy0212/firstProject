package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable{
	@FXML
	private AnchorPane Login;
    @FXML private TextField id;
    @FXML private PasswordField pwd;
    @FXML private ImageView login;
    @FXML private ImageView member;
    @FXML private ImageView exit;
    @FXML private ImageView google;
    @FXML private ImageView facebook;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		member.setOnAction(e->membersAction(e));
	}
    
	
	public void membersAction(ActionEvent event){
		try{
		Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));
		AnchorPane root = (AnchorPane) members.getScene().getRoot();
		root.getChildren().add(members);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
