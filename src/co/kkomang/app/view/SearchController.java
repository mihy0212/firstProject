package co.kkomang.app.view;

import java.awt.TextArea;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.service.BookServiceImpl;
import co.kkomang.app.service.NaverBookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import test.Book;

public class SearchController implements Initializable{

	@FXML AnchorPane anc;
	@FXML ComboBox<String> option;
	@FXML TextField txtSearch;
	@FXML Button btnSearch;
//	@FXML Label laTitle;
//	@FXML Label laLink;
//	@FXML Label laImage;
//	@FXML Label laAuthor;
//	@FXML Label laDiscout;
//	@FXML Label laPublisher;
//	@FXML Label laPubdate;
//	@FXML Label laIsbn;
//	@FXML Label laDescription;
	@FXML VBox vBox;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//콤보박스 초기화
		ObservableList<String> list = FXCollections.observableArrayList(
				"기본", "제목", "저자", "출판사");
		option.setItems(list);
	}
	

	//검색 버튼
	@FXML
	public void searchNaver(ActionEvent actionEvent) {
		String[] opt = {"query", "d_titl","d_auth", "d_publ"};
		int a;
		a = option.getSelectionModel().getSelectedIndex();
		List<BookInfoV> list = NaverBookService.searchBook(opt[a], txtSearch.getText(), 30, 1);
		for(BookInfoV b : list) {
			Label label = new Label();
			
			String str = b.getTitle().replaceAll("<[^>]*>", " ");

			label.setText(str);
			vBox.getChildren().add(label);
			
		}
	}
	
	
	
	//라벨에 결과 표시
//	@FXML
//	public void ShowSearchNaver(BookInfo books) {
//
//		if (books != null) {
//			
//			laTitle.setText(books.getTitle());
//			laLink.setText(books.getLink());
//			laImage.setText(books.getImage());
//			laAuthor.setText(books.getAuthor());
//			laDiscout.setText(books.getDiscount());
//			laPublisher.setText(books.getPublisher());
//			laPubdate.setText(books.getPubdate());
//			laIsbn.setText(books.getIsbn());
//			laDescription.setText(books.getDescription());
//		} else {
//			laTitle.setText("");
//			laLink.setText("");
//			laImage.setText("");
//			laAuthor.setText("");
//			laDiscout.setText("");
//			laPublisher.setText("");
//			laPubdate.setText("");
//			laIsbn.setText("");
//			laDescription.setText("");
//		}
//	}
	
	//결과 호출
	@FXML
	public void selectAllNaver(ActionEvent actionEvent) {
		
	}
	

}
