package co.kkomang.app.view;

import java.net.URL;
import java.util.ResourceBundle;


import co.kkomang.app.service.NaverBookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchController implements Initializable{

	@FXML AnchorPane anc;
	@FXML ComboBox<String> option;
	@FXML TextField txtSearch;
	@FXML Button btnSearch;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//콤보박스 초기화
		ObservableList<String> list = FXCollections.observableArrayList(
				"기본", "제목", "저자", "출판사");
		option.setItems(list);
		
		
	}
	@FXML
	public void searchNaver(ActionEvent actionEvent) {
		String[] opt = {"query", "d_titl","d_auth", "d_publ"};
		int a = option.getSelectionModel().getSelectedIndex();
		NaverBookService.searchBook(opt[a], txtSearch.getText(), 30, 1);
	}
	

}
