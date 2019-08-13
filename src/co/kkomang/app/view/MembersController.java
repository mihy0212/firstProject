package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class MembersController implements Initializable {
	@FXML
	private AnchorPane Member;
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
		cancelBtn.setOnAction(e -> cancelAction(e));
		
		try {
             Parent second =FXMLLoader.load(getClass().getResource("SecondRoot.fxml"));
             Scene scene = new Scene(second);
             Stage primaryStage =(Stage) btnSecond.getScene().getWindow();
             primaryStage.setScene(scene);
         } catch (IOException e) {
             // TODO Auto-generated catch bloc"r
             e.printStackTrace();
         }
     });
		
		
		membersBtn.setOnAction(e -> membersAction(e));
	}

	public void cancelAction(ActionEvent e) {
		StackPane root = (StackPane) cancelBtn.getScene().getRoot();
		root.getChildren().remove(Login);
	}

	public void membersAction(ActionEvent event) {

		StackPane root = (StackPane) cancelBtn.getScene().getRoot();
		root.getChildren().remove(Login);

	}

}
