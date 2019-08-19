package co.kkomang.app.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MemberPop {
	@FXML
	private Button closeButn;
	
	@FXML
	private void closeButtonAction(){
		System.exit(0);
	}
}


