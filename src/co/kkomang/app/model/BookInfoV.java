package co.kkomang.app.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookInfoV {
	
	//필드
	private IntegerProperty isbn;
	private StringProperty title;
	private StringProperty publisher;
	private StringProperty  author;
	private StringProperty  pubdate;
	private IntegerProperty  price;
	private IntegerProperty  discount;
	private StringProperty  image;
	private StringProperty  description;
	private IntegerProperty  category;
	private StringProperty  memo;
	private IntegerProperty  star;
	private IntegerProperty  privateMemo;
	private IntegerProperty  reading;
	private StringProperty  readDate;
	private IntegerProperty  choiceWhere;
	
	//생성자
	public BookInfoV() {
		isbn = new SimpleIntegerProperty();
		title = new SimpleStringProperty();
		publisher = new SimpleStringProperty();
		author = new SimpleStringProperty();
		pubdate = new SimpleStringProperty();
		price = new SimpleIntegerProperty();
		discount = new SimpleIntegerProperty();
		image = new SimpleStringProperty();
		description = new SimpleStringProperty();
		category = new SimpleIntegerProperty();
		memo = new SimpleStringProperty();
		star = new SimpleIntegerProperty();
		privateMemo = new SimpleIntegerProperty();
		reading  = new SimpleIntegerProperty();
		readDate = new SimpleStringProperty();
		choiceWhere = new SimpleIntegerProperty();
	}
	
	//property 넘겨주는 메서드
	public IntegerProperty isbnProperty() {
		return isbn;
	}
	public StringProperty titleProperty() {
		return title;
	}
	public StringProperty publisherProperty() {
		return publisher;
	}
	public StringProperty authorProperty() {
		return author;
	}
	public StringProperty pubdateProperty() {
		return pubdate;
	}
	public IntegerProperty priceProperty() {
		return price;
	}
	public IntegerProperty discountProperty() {
		return discount;
	}
	public StringProperty imageProperty() {
		return image;
	}
	public StringProperty descriptionProperty() {
		return description;
	}
	public IntegerProperty categoryProperty() {
		return category;
	}
	public StringProperty memoProperty() {
		return memo;
	}
	public IntegerProperty starProperty() {
		return star;
	}
	public IntegerProperty privateMemoProperty() {
		return privateMemo;
	}
	public IntegerProperty readingProperty() {
		return reading;
	}
	public StringProperty readDateProperty() {
		return readDate;
	}
	public IntegerProperty choiceWhereProperty() {
		return choiceWhere;
	}

	
	//getter
	public Integer getIsbn() {
		return isbn.get();
	}

	public String getTitle() {
		return title.get();
	}

	public String getPublisher() {
		return publisher.get();
	}

	public String getAuthor() {
		return author.get();
	}

	public String getPubdate() {
		return pubdate.get();
	}

	public Integer getPrice() {
		return price.get();
	}

	public Integer getDiscount() {
		return discount.get();
	}

	public String getImage() {
		return image.get();
	}

	public String getDescription() {
		return description.get();
	}

	public Integer getCategory() {
		return category.get();
	}

	public String getMemo() {
		return memo.get();
	}

	public Integer getStar() {
		return star.get();
	}

	public Integer getPrivateMemo() {
		return privateMemo.get();
	}

	public Integer getReading() {
		return reading.get();
	}

	public String getReadDate() {
		return readDate.get();
	}

	public Integer getChoiceWhere() {
		return choiceWhere.get();
	}
	
	//setter
	
	public void setIsbn(Integer isbn) {
		this.isbn.set(isbn);
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public void setPublisher(String publisher) {
		this.publisher.set(publisher);
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public void setPubdate(String pubdate) {
		this.pubdate.set(pubdate);
	}

	public void setPrice(Integer price) {
		this.price.set(price);
	}

	public void setDiscount(Integer discount) {
		this.discount.set(discount);
	}

	public void setImage(String image) {
		this.image.set(image);
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public void setCategory(Integer category) {
		this.category.set(category);
	}

	public void setMemo(String memo) {
		this.memo.set(memo);
	}

	public void setStar(Integer star) {
		this.star.set(star);
	}

	public void setPrivateMemo(Integer privateMemo) {
		this.privateMemo.set(privateMemo);
	}

	public void setReading(Integer reading) {
		this.reading.set(reading);
	}

	public void setReadDate(String readDate) {
		this.readDate.set(readDate);
	}

	public void setChoiceWhere(Integer choiceWhere) {
		this.choiceWhere.set(choiceWhere);
	}
	
	
	

}
