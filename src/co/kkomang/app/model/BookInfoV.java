package co.kkomang.app.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class BookInfoV {
	
	//필드
	private StringProperty isbn;
    private StringProperty link;
	private StringProperty title;
	private StringProperty publisher;
	private StringProperty author;
	private StringProperty pubdate;
	private StringProperty price;
	private StringProperty discount;
	private StringProperty image;
	private StringProperty description;
	private StringProperty category;
	private StringProperty memo;
	private StringProperty star;
	private StringProperty privateMemo;
	private StringProperty reading;
	private StringProperty readDate;
	
	//생성자
	public BookInfoV() {
		isbn = new SimpleStringProperty();
		link = new SimpleStringProperty();
		title = new SimpleStringProperty();
		publisher = new SimpleStringProperty();
		author = new SimpleStringProperty();
		pubdate = new SimpleStringProperty();
		price = new SimpleStringProperty();
		discount = new SimpleStringProperty();
		image = new SimpleStringProperty();
		description = new SimpleStringProperty();
		category = new SimpleStringProperty();
		memo = new SimpleStringProperty();
		star = new SimpleStringProperty();
		privateMemo = new SimpleStringProperty();
		reading  = new SimpleStringProperty();
		readDate = new SimpleStringProperty();
	}
	
	//property 넘겨주는 메서드
	public StringProperty isbnProperty() {
		return isbn;
	}
	public StringProperty linkProperty() {
		return link;
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
	public StringProperty priceProperty() {
		return price;
	}
	public StringProperty discountProperty() {
		return discount;
	}
	public StringProperty imageProperty() {
		return image;
	}
	public StringProperty descriptionProperty() {
		return description;
	}
	public StringProperty categoryProperty() {
		return category;
	}
	public StringProperty memoProperty() {
		return memo;
	}
	public StringProperty starProperty() {
		return star;
	}
	public StringProperty privateMemoProperty() {
		return privateMemo;
	}
	public StringProperty readingProperty() {
		return reading;
	}

	
	//getter
	public String getIsbn() {
		return isbn.get();
	}
	
	public String getLink() {
		return link.get();
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

	public String getPrice() {
		return price.get();
	}

	public String getDiscount() {
		return discount.get();
	}

	public String getImage() {
		return image.get();
	}

	public String getDescription() {
		return description.get();
	}

	public String getCategory() {
		return category.get();
	}

	public String getMemo() {
		return memo.get();
	}

	public String getStar() {
		return star.get();
	}

	public String getPrivateMemo() {
		return privateMemo.get();
	}

	public String getReading() {
		return reading.get();
	}

	public String getReadDate() {
		return readDate.get();
	}
	
	//setter
	
	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}
	
	public void setLink(String link) {
		this.link.set(link);
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

	public void setPrice(String price) {
		this.price.set(price);
	}

	public void setDiscount(String discount) {
		this.discount.set(discount);
	}

	public void setImage(String image) {
		this.image.set(image);
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public void setCategory(String category) {
		this.category.set(category);
	}

	public void setMemo(String memo) {
		this.memo.set(memo);
	}

	public void setStar(String star) {
		this.star.set(star);
	}

	public void setPrivateMemo(String privateMemo) {
		this.privateMemo.set(privateMemo);
	}

	public void setReading(String reading) {
		this.reading.set(reading);
	}

	public void setReadDate(String readDate) {
		this.readDate.set(readDate);
	}


	@Override
	public String toString() {
		return "BookInfoV [isbn=" + isbn + ", link=" + link + ", title=" + title + ", publisher=" + publisher
				+ ", author=" + author + ", pubdate=" + pubdate + ", price=" + price + ", discount=" + discount
				+ ", image=" + image + ", description=" + description + ", category=" + category + ", memo=" + memo
				+ ", star=" + star + ", privateMemo=" + privateMemo + ", reading=" + reading + ", readDate=" + readDate
				+ ", choiceWhere=" + "]";
	}

	
	
	
	
	

}
