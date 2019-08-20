package co.kkomang.app.view;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MemberPop {
	@FXML
	private Button closeButn;
	
	@FXML
	private void closeButtonAction(){
		closeButn.setOnAction(event->Platform.exit());
	}
}


