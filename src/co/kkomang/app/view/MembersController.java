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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MembersController implements Initializable {
	@FXML
	private AnchorPane members;
	@FXML
	private TextField name;
	@FXML
	private TextField id;
	@FXML
	private PasswordField pwd;
//	@FXML
//	private RadioButton 
	@FXML
	private Button membersBtn;
	@FXML
	private Button cancelBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		cancelBtn.setOnAction(e -> cancelAction(e));
//		membersBtn.setOnAction(e -> membersAction(e));
	}

	public void cancelAction(ActionEvent e) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("members.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
//
//	public void membersAction(ActionEvent event) {
//		StackPane root = (StackPane) cancelBtn.getScene().getRoot();
//		root.getChildren().remove(Login);
//
//	}
	}


