package co.kkomang.app.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.kkomang.app.model.Users;
import co.kkomang.app.service.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
	private Button btnOk;
	@FXML
	private Button btnIdCh;
	@FXML
	private Button btnCancel;
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
	@FXML
	private CheckBox checkAgree;
	@FXML
	private PasswordField txtpasswd2;
	@FXML
	private Label lblPw;
	@FXML
	private CheckBox checkId;
//	@FXML
//	private Label lblId;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}


	public void calcelAction(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btnCancel.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void idcheckAction(ActionEvent e) {
		try {
			UserServiceImpl uService = new UserServiceImpl();
			if (uService.selectOne(txtuserId.getText()) != null) {
				JOptionPane.showMessageDialog(null, "이미있는 아이디 입니다.");
//				lblId.setText("이미있는 아이디 입니다");
			} else {
				JOptionPane.showMessageDialog(null,"사용가능한 아이디 입니다");
			}
		} catch (Exception e2) {
		}
	}


//아이디 중복체크1128 참고 usersevice 수정
//
	@FXML
	private void signUpAction(ActionEvent e) {
//		boolean again = false;
//		while (true) {
		if (e.getSource() == btnOk) {
			if (checkAgree.isSelected() == false) {
				JOptionPane.showMessageDialog(null, "약관동의 체크를 해주세요");
				// 아이디 중복 버튼 클릭 확인
			} else if (checkId.isSelected() == false) {
				JOptionPane.showMessageDialog(null, "id중복확인 해주세요");
			}
			// 약관동의 하면 else실행
			else {// 1else
				String id = txtuserId.getText();
				String pw = txtpasswd.getText();
				String pw2 = txtpasswd2.getText();
				String mail = txtemail.getText();
				String nname = txtnickName.getText();

				boolean check1 = id.isEmpty();
				boolean check2 = pw.isEmpty();
				boolean check3 = pw2.isEmpty();
				boolean check4 = mail.isEmpty();
				boolean check5 = nname.isEmpty();
//					boolean check6 = txtAge.getText().isEmpty();
				if (check1 == true && check2 == true && check3 == true && check4 == true && check5 == true) {
					JOptionPane.showMessageDialog(null, "빈칸을 모두 입력해주세요");
				}
//				if(TextField.setO) 
				else if (pw.equals(pw2) != true) {
					lblPw.setText("비밀번호가 일치하지 않습니다.");// FIXME
					// 리스너에서
					txtpasswd.setText("");
					txtpasswd2.setText("");
				}
				else {
					insetUser();
					showPopView();
					showLogView();
				}
			} // 1else
		} // btnOK if

	}

//@FXML
//private void checkAction(keybo ) {
	public void showLogView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			Scene scene1 = new Scene(login);
			Stage primaryStage = (Stage) btnOk.getScene().getWindow();
			primaryStage.setScene(scene1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showPopView() {
		try {
			Stage pop = new Stage(StageStyle.UTILITY);// 새스테이지 추가
			pop.initModality(Modality.WINDOW_MODAL);//
			pop.initOwner(btnOk.getScene().getWindow());
			Parent popup = FXMLLoader.load(getClass().getResource("memberPop.fxml"));// 새 레이아웃 추가
			Scene scene = new Scene(popup);// 씬에 레이아웃 추가
			pop.setScene(scene); // 씬에 레이아웃 추가
			pop.setResizable(false);
			pop.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insetUser() {
		try {
			Users user = new Users();
			user.setUserId(txtuserId.getText());// 텍스트 입력 textField.setText(텍스트);
			user.setPasswd(txtpasswd.getText());
			user.setPasswd(txtpasswd2.getText());
			user.setEmail(txtemail.getText());
			user.setNickName(txtnickName.getText());
			user.setAge(Integer.parseInt(txtAge.getText()));
//				user.setSex(Integer.parseInt(txtsex.getText()));			
			UserServiceImpl.getInstance().insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// insetUser()

	@FXML
	public void chPw(KeyEvent e) {
		String pw = txtpasswd.getText();
		String pw2 = txtpasswd2.getText();
//				TextField txtpasswd = (TextField) e.getSource();
//		if(pw !=null && pw2==null) {
//			lblPw.setText("한번더 입력해주세요.");// FIXME
//		}
		if (pw.equals(pw2)) {
			lblPw.setText("비밀번호가 일치합니다.");// FIXME
//			txtpasswd.setText("");
//			txtpasswd2.setText("");
		} else if(pw != pw2) {
			lblPw.setText("비밀번호가 일치하지않습니다.");// FIXME
		}
	}

}// class MembersController

//아이디 중복체크1128 참고 usersevice 수정

//@FXML
//private void signUpAction(ActionEvent e) {
////	boolean again = false;
////	while (true) {
//	if (e.getSource() == btnOk) {
//		if (checkAgree.isSelected() == false) {
//			JOptionPane.showMessageDialog(null, "약관동의 체크를 해주세요");
//			// 약관동의 하면 else실행
//		} else {
//			String id = txtuserId.getText();
//			String pw = txtpasswd.getText();
//			String pw2 = txtpasswd2.getText();
//			String mail = txtemail.getText();
//			String nname = txtnickName.getText();
//
//			boolean check1 = id.isEmpty();
//			boolean check2 = pw.isEmpty();
//			boolean check3 = pw2.isEmpty();
//			boolean check4 = mail.isEmpty();
//			boolean check5 = nname.isEmpty();
////				boolean check6 = txtAge.getText().isEmpty();
//			if (check1 == true && check2 == true && check3 == true && check4 == true && check5 == true) {
//				JOptionPane.showMessageDialog(null, "빈칸을 모두 입력해주세요");
//			} else if (pw.equals(pw2) != true) {
//				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");// FIXME
//			}
////			if (e.getSource() == btnOk) {
////				if (checkId.isSelected() == false) {
////					JOptionPane.showMessageDialog(null, "아이디 중복을 체크 해주세요");
//			else {
//				try {
//					Users user = new Users();
//					user.setUserId(txtuserId.getText());
//					user.setPasswd(txtpasswd.getText());
//					user.setPasswd(txtpasswd2.getText());
//					user.setEmail(txtemail.getText());
//					user.setNickName(txtnickName.getText());
//					user.setAge(Integer.parseInt(txtAge.getText()));
////							user.setSex(Integer.parseInt(txtsex.getText()));			
//					UserServiceImpl.getInstance().insert(user);
//
//					Stage pop = new Stage(StageStyle.UTILITY);// 새스테이지 추가
//					pop.initModality(Modality.WINDOW_MODAL);//
//					pop.initOwner(btnOk.getScene().getWindow());
//					Parent popup = FXMLLoader.load(getClass().getResource("memberPop.fxml"));// 새 레이아웃 추가
//					Scene scene = new Scene(popup);// 씬에 레이아웃 추가
//					pop.setScene(scene); // 씬에 레이아웃 추가
//					pop.setResizable(false);
//					pop.show();
//
//					Parent login = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
//					Scene scene1 = new Scene(login);
//					Stage primaryStage = (Stage) btnOk.getScene().getWindow();
//					primaryStage.setScene(scene1);
////						again = true;
//				} catch (Exception e1) {
//				} // catch
//			}
//		} // else
//	} // btnOK
//
//}

// public void calcelAction(ActionEvent event) {
//		try {
//			Stage can = new Stage(StageStyle.UTILITY);
//			can.initModality(Modality.WINDOW_MODAL);
//			can.initOwner(btnCancel.getScene().getWindow());	
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