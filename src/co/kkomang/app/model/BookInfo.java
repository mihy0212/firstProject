package co.kkomang.app.model;


public class BookInfo {

	private String isbn;
	private String link;
	private String title;
	private String publisher;
	private String author;
	private String pubdate;
	private String price;
	private String discount;
	private String image;
	private String description; //여기까지 네이버에서 가져 올 정보
	private String category;
	private String memo;
	private String star;
	private String privateMemo;
	private String reading;
	private String readDate;
	private String userId;
	
	public String getIsbn() {
		return isbn;
	}
	public String getLink() {
		return link;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getPrivateMemo() {
		return privateMemo;
	}
	public void setPrivateMemo(String privateMemo) {
		this.privateMemo = privateMemo;
	}
	public String getReading() {
		return reading;
	}
	public void setReading(String reading) {
		this.reading = reading;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "BookInfo [isbn=" + isbn + ", link=" + link + ", title=" + title + ", publisher=" + publisher
				+ ", author=" + author + ", pubdate=" + pubdate + ", price=" + price + ", discount=" + discount
				+ ", image=" + image + ", description=" + description + ", category=" + category + ", memo=" + memo
				+ ", star=" + star + ", privateMemo=" + privateMemo + ", reading=" + reading + ", readDate=" + readDate
				+ ", userId=" + userId + "]";
	}
	

	
}
