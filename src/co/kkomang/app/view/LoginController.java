package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
	@FXML
	private Button loginBtn;
//	private User user;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		membersBtn.setOnAction(event -> membersAction(event));
	}

	public void membersAction(ActionEvent event) {
		try {
			Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));// 새 레이아웃 추가
			Scene scene = new Scene(members);// 씬에 레이아웃 추가
			Stage primaryStage = (Stage) membersBtn.getScene().getWindow();
			primaryStage.setScene(scene);
//			mem.setScene(scene); // 씬에 레이아웃 추가//이 코드 있을 경우 member에서 canel 사용불가
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	//db연결
//		public void LoginAction(ActionEvent event) {
//			try {
//				UserServiceImpl uService = new UserServiceImpl();
//
//				if (uService.login(txtUserName.getText(), txtPassword.getText()) != null) {
////					uService.login(txtUserName.getText(), txtPassword.getText());
//					lblStatus.setText("로그인 되었습니다");
//				Parent home = FXMLLoader.load(getClass().getResource("Home.fxml"));// 새 레이아웃 추가
//				Scene scene = new Scene(home);// 씬에 레이아웃 추가
//				Stage primaryStage = (Stage) membersBtn.getScene().getWindow();
//				primaryStage.setScene(scene);
//				}
//				else {
//					lblStatus.setText("아이디와 비밀번호를 확인주세요");
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				
//			}
//
//		}
//	}
	//db연결
	public void LoginAction(ActionEvent event) {
		try {
			UserServiceImpl uService = new UserServiceImpl();
			//정상 로그인이 되었을 경우
			if (uService.login(txtUserName.getText(), txtPassword.getText()) != null) {
				uService.login(txtUserName.getText(), txtPassword.getText());
				lblStatus.setText("로그인 되었습니다");
			//로그인 성공시 화면 전환
			Parent home = FXMLLoader.load(getClass().getResource("Home.fxml"));// 새 레이아웃 추가
			Scene scene = new Scene(home);// 씬에 레이아웃 추가
			Stage primaryStage = (Stage) membersBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			}
			//입력안했을경우
			else if (txtUserName.getText().equals("") || txtPassword.getText().equals("")) {
				lblStatus.setText( "아이디와 비밀번호를 입력해주세요");
			}
			//아이디와 비밀번호가 틀린경우
			else {
				lblStatus.setText("아이디와 비밀번호를 확인주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
}



//
//	public void LoginAction(ActionEvent event) throws Exception {
//		if (txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")) {
//			lblStatus.setText("Login Success");
//			// 새스테이지 추가
//			Stage primaryStage = new Stage();
//			// 새 레이아웃 추가
//			Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
//			// 새 레이아웃 추가
//			Scene scene = new Scene(root);
////	            scene.getStylesheets().add(getClass().getResource("btn.css").toExternalForm());
//			// 씬을 스테이지에서 상영
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} else {
//			lblStatus.setText("Login Failed");
//		}
//	}
	
	/*
	 * 자바는 컨트롤에서 이벤트를 직접 처리하지 않고 EventHandler에게 처리를 맡긴다. 그래서 버튼을 클릭하면 ActionEvent가
	 * 발생하고 EventHandler가 이 ActionEvent를 처리하는 방식
	 */
//		@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		EventHandler<ActionEvent> handler = new LoginHandler();
//		loginBtn.setOnAction(handler);
//		membersBtn.setOnAction(e -> membersAction(e));
//	}
//	class LoginHandler implements EventHandler<ActionEvent> {
//		@Override
//		public void handle(ActionEvent event)  {
//				Parent root;
//				try {
//					if (txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")) {
//						lblStatus.setText("Login Success");
//						// 새스테이지 추가
//						Stage primaryStage = new Stage();
//						// 새 레이아웃 추가
//					root = FXMLLoader.load(getClass().getResource("home.fxml"));
//					// 새 레이아웃 추가
//					Scene scene = new Scene(root);
////			            scene.getStylesheets().add(getClass().getResource("btn.css").toExternalForm());
//					// 씬을 스테이지에서 상영
//					primaryStage.setScene(scene);
//					primaryStage.show();
//					}
//				 else {
//					lblStatus.setText("Login Failed");
//					
//				}
//				}catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} 
//	}
//	LoginVeiw 수정
//	<Button fx:id="loginBtn" graphicTextGap="10.0" layoutX="373.0" layoutY="465.0" mnemonicParsing="false" prefHeight="50.0" prefWidth="91.0" style="-fx-background-color: black; " text="login" />
//    <Button fx:id="membersBtn" graphicTextGap="10.0" layoutX="63.0" layoutY="465.0" mnemonicParsing="false" prefHeight="50.0"prefWidth="91.0" style="-fx-background-color: black; " text="member" textAlignment="CENTER" />


/*
 * 메소드 호출안하고 사용하기 기존화면 놔두고
 */
//public void membersAction(ActionEvent event) {
//	try {
//		Stage mem = new Stage(StageStyle.UTILITY);// 새스테이지 추가
//		mem.initModality(Modality.WINDOW_MODAL);//
//		mem.initOwner(membersBtn.getScene().getWindow());
//		Parent members = FXMLLoader.load(getClass().getResource("members.fxml"));// 새 레이아웃 추가
//		Scene scene = new Scene(members);// 씬에 레이아웃 추가
////					mem.setScene(scene); // 씬에 레이아웃 추가
////		 mem.setResizable(false);
////		mem.show();
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
