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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FirstController implements Initializable {
	@FXML
	private Button startbtn;
	
	@FXML
	private AnchorPane first;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startbtn.setOnAction(e-> handlebtnStart(e));
	}

	public void handlebtnStart(ActionEvent event) {

		try {
			Stage srt = new Stage(StageStyle.UTILITY);
			srt.initModality(Modality.WINDOW_MODAL);
			srt.initOwner(startbtn.getScene().getWindow());	
			Parent login = FXMLLoader.load(getClass().getResource("LoginVeiw.fxml"));
			Scene scene = new Scene(login);
			srt.setScene(scene);
			srt.setResizable(false);
			srt.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
