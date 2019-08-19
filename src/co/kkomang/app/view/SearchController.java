package co.kkomang.app.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.service.BookServiceImpl;
import co.kkomang.app.service.NaverBookService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class SearchController implements Initializable{

	@FXML private AnchorPane anc;
	@FXML private ComboBox<String> option;
	@FXML private TextField txtSearch;
	@FXML private Button btnSearch;
	
	
	@FXML private Label laTitle;
	@FXML private Label laAuthor;
	@FXML private Label laPublisher;
	@FXML private Label laPubdate;
	@FXML private Label laIsbn;
	@FXML private Label laDiscount;
	@FXML private Label laDescription;
	@FXML private ImageView imgImage;
	
	@FXML private Button btnInsert;

	@FXML private TableView<BookInfoV> tvBooks;
//	@FXML private TableColumn<BookInfoV, ImageView> colImage;
	@FXML private TableColumn<BookInfoV, String> colImage;
	@FXML private TableColumn<BookInfoV, String> colTitle;
	@FXML private TableColumn<BookInfoV, String> colAuthor;
	@FXML private TableColumn<BookInfoV, String> colPublisher;
	@FXML private TableColumn<BookInfoV, String> colPubdate;
	@FXML private TableColumn<BookInfoV, String> colIsbn;
	@FXML private TableColumn<BookInfoV, String> colDiscount;
	@FXML private TableColumn<BookInfoV, String> colDescription;
	
	private Executor exec;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//콤보박스 초기화
		ObservableList<String> list = FXCollections.observableArrayList(
				"기본", "제목", "저자", "출판사");
		option.setItems(list);
		
		//테이블뷰 초기화
//		ImageView image = new ImageView();
//		Image img = new Image(url);
//		image.setImage(img);
		colImage.setCellValueFactory(cellData -> cellData.getValue().imageProperty());
		colTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		colAuthor.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
		colPublisher.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
		colPubdate.setCellValueFactory(cellData -> cellData.getValue().pubdateProperty());
		colIsbn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
		colDiscount.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
		colDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
	
		//쓰레드풀 생성
		exec = Executors.newCachedThreadPool((runnable) -> { Thread t = new Thread (runnable); t.setDaemon(true);
		return t; });
		
		//책 정보 초기화
		showBooksDetail(null);
		tvBooks.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> showBooksDetail(newValue));
	
	}	

	//검색 버튼
	@FXML
	public void searchNaver(ActionEvent actionEvent) {
		String[] opt = {"query", "d_titl","d_auth", "d_publ"};
		int a;
		a = option.getSelectionModel().getSelectedIndex();
		Task<ObservableList<BookInfoV>> task = new Task<ObservableList<BookInfoV>>() {

			@Override
			protected ObservableList<BookInfoV> call() throws Exception {
				List<BookInfoV> list = NaverBookService.searchBook(opt[a], txtSearch.getText(), 30, 1);
				ObservableList<BookInfoV> obsList=FXCollections.observableArrayList(list);
				return obsList;
			}
		};
		
		// 작업 실행 완료 후 호출
		task.setOnSucceeded(e -> tvBooks.setItems((ObservableList<BookInfoV>) task.getValue()));
		// 작업 실행
		exec.execute(task);

//		for(BookInfoV b : list) {
//			Label label = new Label();
//
//			String str = b.getTitle().replaceAll("<[^>]*>", " ");
//			String url = b.getImage();
//			ImageView image = new ImageView();
//			Image img = new Image(url);
//			label.setText(str);
//			
//			image.setImage(img);
//			label.setText(b.getAuthor());
//			label.setText(b.getDiscount());
//			label.setText(b.getPublisher());
//			label.setText(b.getPubdate());
//			label.setText(b.getIsbn());
//			label.setText(b.getDescription());
//			vBox.getChildren().add(label);
//			
//		}
	}
	
	private void showBooksDetail(BookInfoV books) {
		if(books != null) {
			laTitle.setText(books.getTitle());
			laAuthor.setText(books.getAuthor());
			laPublisher.setText(books.getPublisher());
			laPubdate.setText(books.getPubdate());
			laIsbn.setText(books.getIsbn());
			laDiscount.setText(books.getDiscount());
			laDescription.setText(books.getDescription());
			String url = books.getImage();
			Image img = new Image(url);
			imgImage.setImage(img);
		} else {
			laTitle.setText("");
			laAuthor.setText("");
			laPublisher.setText("");
			laPubdate.setText("");
			laIsbn.setText("");
			laDiscount.setText("");
			laDescription.setText("");
			imgImage.setImage(null);
		}
	}
	
	@FXML
	protected void getInformation(MouseEvent event) {
		laTitle.setText(tvBooks.getSelectionModel().getSelectedItem().getTitle());
		laAuthor.setText(tvBooks.getSelectionModel().getSelectedItem().getAuthor());
		laPublisher.setText(tvBooks.getSelectionModel().getSelectedItem().getPublisher());
		laPubdate.setText(tvBooks.getSelectionModel().getSelectedItem().getPubdate());
		laIsbn.setText(tvBooks.getSelectionModel().getSelectedItem().getIsbn());
		laDiscount.setText(tvBooks.getSelectionModel().getSelectedItem().getDiscount());
		laDescription.setText(tvBooks.getSelectionModel().getSelectedItem().getDescription());
		String url = tvBooks.getSelectionModel().getSelectedItem().getImage();
		Image img = new Image(url);
		imgImage.setImage(img);
	}
	
	//내서재에 등록
	@FXML
	private void insertMyBooks(ActionEvent actionEvent) {
		try {
			BookInfo books = new BookInfo();
			books.setTitle(laTitle.getText());
			books.setAuthor(laAuthor.getText());
			books.setPublisher(laPublisher.getText());
			books.setPubdate(laPubdate.getText());
			books.setIsbn(laIsbn.getText());
			books.setDiscount(laDiscount.getText());
			books.setDescription(laDescription.getText());
			books.setImage(imgImage.getId());
			
			books.setCategory("1");
			books.setMemo("1");
			books.setPrice("1");
			books.setPrivateMemo("1");
			books.setReadDate("18/12/12");
			books.setReading("1");
			books.setStar("1");
			books.setLink("1");
			BookServiceImpl.getInstance().insert(books);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
