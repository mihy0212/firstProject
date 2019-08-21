package co.kkomang.app.view;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MemberPop {
	@FXML
	private Button closeButn;
	
	@FXML
	private void closeButtonAction(){
//		closeButn.setOnAction(event->Platform.exit());
		 // get a handle to the stage
	    Stage stage = (Stage) closeButn.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
}


