package co.kkomang.app.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.service.BookServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController implements Initializable {
	
	@FXML private AnchorPane home;
	@FXML private TableView<BookInfoV> tvBooks;
	@FXML private TableColumn<BookInfoV, String> colIsbn;
//	@FXML private TableColumn<BookInfoV, String> colLink;
	@FXML private TableColumn<BookInfoV, String> colTitle;
//	@FXML private TableColumn<BookInfoV, String> colPublisher;
	@FXML private TableColumn<BookInfoV, String> colAuthor;
//	@FXML private TableColumn<BookInfoV, String> colPubdate;
//	@FXML private TableColumn<BookInfoV, String> colPrice;
//	@FXML private TableColumn<BookInfoV, String> colDiscount;
//	@FXML private TableColumn<BookInfoV, String> colImage;
//	@FXML private TableColumn<BookInfoV, String> colDescription;
	@FXML private TableColumn<BookInfoV, String> colCategory;
//	@FXML private TableColumn<BookInfoV, String> colMemo;
//	@FXML private TableColumn<BookInfoV, String> colStar;
//	@FXML private TableColumn<BookInfoV, String> colPrivateMemo;
	@FXML private TableColumn<BookInfoV, String> colReading;
	@FXML private TableColumn<BookInfoV, String> colReadDate;
	
	private Executor exec;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// 테이블뷰 초기화
		colIsbn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
//		colLink.setCellValueFactory(cellData -> cellData.getValue().linkProperty());
		colTitle.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
//		colPublisher.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
		colAuthor.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
//		colPubdate.setCellValueFactory(cellData -> cellData.getValue().pubdateProperty());
//		colPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
//		colDiscount.setCellValueFactory(cellData -> cellData.getValue().discountProperty());
//		colImage.setCellValueFactory(cellData -> cellData.getValue().imageProperty());
//		colDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		colCategory.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
//		colMemo.setCellValueFactory(cellData -> cellData.getValue().memoProperty());
//		colStar.setCellValueFactory(cellData -> cellData.getValue().starProperty());
//		colPrivateMemo.setCellValueFactory(cellData -> cellData.getValue().privateMemoProperty());
		colReading.setCellValueFactory(cellData -> cellData.getValue().readingProperty());
		colReadDate.setCellValueFactory(cellData -> cellData.getValue().readDateProperty());
		
		// 쓰레드풀 생성
		exec = Executors.newCachedThreadPool((runnable) -> {
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});

		// 책 정보 초기화
		selectAllDept();
		
		//테이블뷰 선택 팝업
		tvBooks.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> showBookDetails(newValue));

	}
	
	private void selectAllDept() {
		Task<ObservableList<BookInfoV>> task = new Task<ObservableList<BookInfoV>>() {

			@Override
			protected ObservableList<BookInfoV> call() throws Exception {
				List<BookInfoV> list = BookServiceImpl.getInstance().selectAllV();
				ObservableList<BookInfoV> obsList=FXCollections.observableArrayList(list);
				return obsList;
			}
		};
		//작업 실행 완료 후 호출
		task.setOnSucceeded(
			e -> tvBooks.setItems((ObservableList<BookInfoV>) task.getValue()));
		//작업 실행
		exec.execute(task);
	}
	
	public void showBookDetails(BookInfoV books) {
		try {
			//fxml파일을 로드하고 나서 새로운 새로운 스테이지를 만든다.
//	        AnchorPane page = FXMLLoader.load(getClass().getResource("readbook.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("readbook.fxml"));
			AnchorPane root = loader.load();
	        Stage primaryStage = (Stage) home.getScene().getWindow();
			
			//선택한 책의 상세보기 팝업 틀(stage)
			Stage readBookStage = new Stage();
			readBookStage.setTitle("책 상세보기 : 독서기록장");
			readBookStage.initModality(Modality.WINDOW_MODAL);
			readBookStage.initOwner(primaryStage);
			
			//stage의 씬
			Scene scene = new Scene(root);
			readBookStage.setScene(scene);
			
			//자식 컨트롤러와 연결하여 값 넘겨주기
			//ReadBookController controller =
			ReadBookController controller = loader.getController();
			controller.initData(books.getIsbn());
			
	        //
	        readBookStage.show();
	        

			
		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
	
	
	

}
