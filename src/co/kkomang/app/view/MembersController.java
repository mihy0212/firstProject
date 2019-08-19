package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.kkomang.app.model.Users;
import co.kkomang.app.service.UserServiceImpl;
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

//	@FXML
//	private RadioButton 
	@FXML
	private Button okBtn;
	@FXML
	private Button loginBtn;
	@FXML
	private Button cancelBtn;
	@FXML
	private TextField txtuserId;
	@FXML
	private PasswordField txtpasswd;
	@FXML
	private TextField txtemail;
	@FXML
	private TextField txtnickName;
	@FXML
	private TextField txtAge;
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cancelBtn.setOnAction(e -> calcelAction(e));
		okBtn.setOnAction(e->insertUser(e));
		
	}

//	private Object membersAction(ActionEvent e) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@FXML
	private void insertUser(ActionEvent e) {
		try {

			Users user = new Users();
			user.setUserId(txtuserId.getText());
			user.setPasswd(txtpasswd.getText());
			user.setEmail(txtemail.getText());
			user.setNickName(txtnickName.getText());
			user.setAge(Integer.parseInt(txtAge.getText()));
//			user.setSex(Integer.parseInt(txtsex.getText()));			
			UserServiceImpl.getInstance().insert(user);
			
			Stage pop = new Stage(StageStyle.UTILITY);// 새스테이지 추가
			pop.initModality(Modality.WINDOW_MODAL);//
			pop.initOwner(okBtn.getScene().getWindow());
			Parent popup = FXMLLoader.load(getClass().getResource("memberPop.fxml"));// 새 레이아웃 추가
			Scene scene = new Scene(popup);// 씬에 레이아웃 추가
			pop.setScene(scene); // 씬에 레이아웃 추가
			pop.setResizable(false);
			pop.show();
			
			
			Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene1 = new Scene(login);
			Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
			primaryStage.setScene(scene1);

		
			
		} catch (Exception e1) {
			
			
		}
		
	}
	


	//	public void calcelAction(ActionEvent event) {
//		try {
//			Stage can = new Stage(StageStyle.UTILITY);
//			can.initModality(Modality.WINDOW_MODAL);
//			can.initOwner(cancelBtn.getScene().getWindow());	
//			Parent cancel = FXMLLoader.load(getClass().getResource("members.fxml"));
//			Scene scene = new Scene(cancel);
//			can.setScene(scene);
//			can.setResizable(false);
//			can.show();	
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public void calcelAction(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) cancelBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
	


