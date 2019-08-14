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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
	private Button okBtn;
	@FXML
	private Button cancelBtn;
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cancelBtn.setOnAction(e -> membersAction(e));
	}


	public void membersAction(ActionEvent event) {
		try {
			Stage can = new Stage(StageStyle.UTILITY);
			can.initModality(Modality.WINDOW_MODAL);
			can.initOwner(cancelBtn.getScene().getWindow());	
			Parent cancel = FXMLLoader.load(getClass().getResource("members.fxml"));
			Scene scene = new Scene(cancel);
			can.setScene(scene);
			can.setResizable(false);
			can.show();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
	


