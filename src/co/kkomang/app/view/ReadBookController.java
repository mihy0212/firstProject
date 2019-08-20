package co.kkomang.app.view;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.service.BookServiceImpl;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReadBookController implements Initializable{

	@FXML private AnchorPane ancRead;
	
	@FXML private ComboBox<String> comboCategory;
	@FXML private ImageView imgBook;
	@FXML private Label laTitle;
	@FXML private Label laIsbn;
	@FXML private Label laAuthor;
	@FXML private Label laPublisher;
	@FXML private Label laPubdate;
	@FXML private RadioButton reading1;
	@FXML private RadioButton reading2;
	@FXML private DatePicker pickReadDate;
	@FXML private TextField txtStar;
	@FXML private CheckBox btnPrivateMemo;
	@FXML private TextArea txtDescription;
	@FXML private TextArea txtMemo;
	@FXML private Hyperlink hyLink;
	@FXML private TextField txtPrice;
	@FXML private TextField txtDiscount;
	

	@FXML private Button btnUpdate;
	@FXML private Button btnDelete;
	
	private Stage readBookStage;
	private BookInfo books;
	private Executor exec;
	
	final ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 쓰레드풀 생성
		exec = Executors.newCachedThreadPool((runnable) -> {
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});
		

		
		
		
	}
	
	private void selectOneBooks() {
		String isbn = laIsbn.getText();
		BookInfo books = BookServiceImpl.getInstance().selectIsbn(isbn);
		
		String url = books.getImage();
		Image img = new Image(url);
		imgBook.setImage(img);
		
		laTitle.setText(books.getTitle());
		laAuthor.setText(books.getAuthor());
		laPublisher.setText(books.getPublisher());
		
		int pubdateYY = getFromCalendar(books.getPubdate(),Calendar.YEAR);
		int pubdateMM = getFromCalendar(books.getPubdate(),Calendar.MONTH);
		int pubdateDD = getFromCalendar(books.getPubdate(),Calendar.DAY_OF_MONTH);
		laPubdate.setText(pubdateYY+"년 "+pubdateMM+"월 "+pubdateDD+"일"); // 이것도 년월일로 나와야 함
		
		//'읽기 진행 상황' 그룹으로 묶기
		reading1.setUserData("1");
		reading1.setToggleGroup(group);
		reading2.setUserData("2");
		reading2.setToggleGroup(group);
		
		reading1.setSelected(true);
		reading1.requestFocus();
		
		group.selectedToggleProperty().addListener(
			(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
				if(group.getSelectedToggle() !=null) {
					String selectData = group.getSelectedToggle().getUserData().toString();
					System.out.println(selectData);
				}
			}
		);
		
//		pickReadDate.setValue(Integer.parseInt(books.getReadDate()));
		int readDateYY = getFromCalendar(books.getReadDate(),Calendar.YEAR);
		int readDateMM = getFromCalendar(books.getReadDate(),Calendar.MONTH);
		int readDateDD = getFromCalendar(books.getReadDate(),Calendar.DAY_OF_MONTH);
		pickReadDate.setValue(LocalDate.of (readDateYY, readDateMM, readDateDD));
		
		txtStar.setText(books.getStar());
		txtDescription.setText(books.getDescription());
		txtMemo.setText(books.getMemo());
		hyLink.setText(books.getLink());
		txtPrice.setText(books.getPrice());
		txtDiscount.setText(books.getDiscount());
	}
	
	public void initData(String isbn) {
		laIsbn.setText(isbn);
		selectOneBooks();
	}
	
	
	@FXML
	private void insertBooks(ActionEvent actionEvent) {
		try {
			books = new BookInfo();
			books.setAuthor(laAuthor.getText());
			books.setCategory("1");
			books.setDescription(txtDescription.getText());
			books.setDiscount(txtDiscount.getText());
			books.setImage(imgBook.getId());
			books.setIsbn(laIsbn.getText());
			books.setLink(hyLink.getText());
			books.setMemo(txtMemo.getText());
			books.setPrice(txtPrice.getText());
			books.setPrivateMemo("0");
			books.setPubdate(laPubdate.getText());
			books.setPublisher(laPublisher.getText());
			books.setReadDate(pickReadDate.getId());
			books.setReading(group.toString());
			books.setStar(txtStar.getText());
			books.setTitle(laTitle.getText());
			
			BookServiceImpl.getInstance().insert(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void deleteBooks(ActionEvent actionEvent) {
		try {
			String isbn = laIsbn.getText();
			BookServiceImpl.getInstance().delete(isbn);
			//삭제한 후에는 창이 꺼져야 함...
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private int getFromCalendar(String strDate, int field)
	{
	    int result = -1;
	    try {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");// this is your date format "12/24/2013" = "MM/dd/yyy"
	        java.util.Date date = formatter.parse(strDate);//convert to date
	        Calendar cal = Calendar.getInstance();// get calendar instance
	        cal.setTime(date);//set the calendar date to your date
	        result = cal.get(field); // get the required field  
	        return result;//return the result.
	    }
	    catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	

	
	



}
