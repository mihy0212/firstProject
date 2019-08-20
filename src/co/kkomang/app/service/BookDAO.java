package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;

public class BookDAO {
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	//싱글톤
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	
	//책 정보 등록
	public void insert(Connection conn, BookInfo book) throws SQLException {
		String sql = "insert into books (isbn,"
				+ " link,"
				+ " title,"
				+ " publisher,"
				+ " author,"
				+ " pubdate,"
				+ " price,"
				+ " discount,"
				+ " image,"
				+ " description,"
				+ " category,"
				+ " memo,"
				+ " star,"
				+ " private_memo,"
				+ " reading,"
				+ " read_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getIsbn());
		pstmt.setString(2, book.getLink());
		pstmt.setString(3, book.getTitle());
		pstmt.setString(4, book.getPublisher());
		pstmt.setString(5, book.getAuthor());
		pstmt.setString(6, book.getPubdate());
		pstmt.setString(7, book.getPrice());
		pstmt.setString(8, book.getDiscount());
		pstmt.setString(9, book.getImage());
		pstmt.setString(10, book.getDescription());
		pstmt.setString(11, book.getCategory());
		pstmt.setString(12, book.getMemo());
		pstmt.setString(13, book.getStar());
		pstmt.setString(14, book.getPrivateMemo());
		pstmt.setString(15, book.getReading());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 등록 완료");
	}
	
	//책 정보수정
	public void update(Connection conn, BookInfo book) throws SQLException {
		System.out.println(book);
		String sql = "update books set title=?,"
				+ " link=?,"
				+ " publisher=?,"
				+ " author=?,"
				+ " pubdate=to_date(?, 'yyyyMMdd'),"
				+ " price=?,"
				+ " discount=?,"
				+ " image=?,"
				+ " description=?,"
				+ " category=?,"
				+ " memo=?,"
				+ " star=?,"
				+ " private_memo=?,"
				+ " reading=?,"
				+ " read_date=to_date(?, 'yyyy-MM-dd')"
				+ " where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getLink());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getAuthor());
		pstmt.setString(5, book.getPubdate());
		pstmt.setString(6, book.getPrice());
		pstmt.setString(7, book.getDiscount());
		pstmt.setString(8, book.getImage()); 
		pstmt.setString(9, book.getDescription());
		pstmt.setString(10, book.getCategory());
		pstmt.setString(11, book.getMemo());
		pstmt.setString(12, book.getStar());
		pstmt.setString(13, book.getPrivateMemo());
		pstmt.setString(14, book.getReading());
		pstmt.setString(15, book.getReadDate());
		pstmt.setString(16, book.getIsbn());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 수정 완료");
	}
	
	//책 정보삭제
	public void delete(Connection conn, String isbn) throws SQLException {
		String sql = "delete from books where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 삭제 완료");
	}
	
	
	/*
	 * 아래부터는 책 조회
	 * 1. ISBN으로 책 한 건 조회 : BookInfo타입 -> selectIsbn(Connection conn, String isbn)메서드
	 * 2. 책 제목으로 책 조회 : List<BookInfo> -> selectTitle(Connection conn, String title)
	 * 3. 조건별로 책 조회 : List<BookInfo> -> search(Connection conn, Map<> mapSearch)
	 * 4. 책 전체 조회 : List<BookInfo> -> selectAll(Connection conn)
	 * 4. 뷰를 위한 1 : BookInfoV -> selectIsbnV(Connection conn, String isbn)
	 * 5. 뷰를 위한 2 : List<BookInfoV> -> selectTitleV(Connection conn, String title)
	 * 6. 뷰를 위한 3 : List<BookInfoV> -> searchV(Connection conn, Map<> mapSearch)
	 * 7. 뷰를 위한 4 : List<BookInfoV> -> selectAllV(Connection conn)
	 * 8. DTO없이 조회하기(예제) List<Map<String, Object>> -> selectAllMap(Connection conn)
	 */
	
	
	//1. ISBN으로 책 한 건 조회
	public BookInfo selectIsbn(Connection conn, String isbn) throws SQLException {
		BookInfo books = null;
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books"
				+ " where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			books = new BookInfo();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			
		}
		return books;
	}
	
	//2. 책 제목으로 검색
	public List<BookInfo> selectTitle(Connection conn, String title) throws SQLException {
		List<BookInfo> list = new ArrayList<>();
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfo books = new BookInfo();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			list.add(books);
			
		}
		return list;
	}
	
	/*
	 * 책 조건별 검색 : isbn, title, publisher, author, category
	 */
	
	//3. 책 조건별로 검색
//		public List<BookInfo> search(Connection conn, Map<String, String> mapSearch) throws SQLException {
//			List<BookInfo> list = new ArrayList<>();
//			Set<String> keySet = map.
//			if(mapSearch. == "Isbn")
//			String sql = "select * from books where title=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, title);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				BookInfo books = new BookInfo();
//				books.setIsbn(rs.getString("isbn"));
//				books.setTitle(rs.getString("title"));
//				books.setPublisher(rs.getString("publisher"));
//				books.setAuthor(rs.getString("author"));
//				books.setPubdate(rs.getString("pubdate"));
//				books.setPrice(rs.getString("price"));
//				books.setDiscount(rs.getString("discount"));
//				books.setImage(rs.getString("image"));
//				books.setDescription(rs.getString("description"));
//				books.setCategory(rs.getString("category"));
//				books.setMemo(rs.getString("memo"));
//				books.setStar(rs.getString("star"));
//				books.setPrivateMemo(rs.getString("private_memo"));
//				books.setReading(rs.getString("reading"));
//				books.setReadDate(rs.getString("read_date"));
//				books.setChoiceWhere(rs.getString("choice_where"));
//				list.add(books);
//				
//			}
//			return list;
//		}
	
	
	//4. 책 전체 조회
	public List<BookInfo> selectAll(Connection conn) throws SQLException {
		List<BookInfo> list = new ArrayList<>();
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfo books = new BookInfo();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			list.add(books);
		}
		return list;
	}
	
	//5. View를 위한 ISBN으로 책 한 건 조회
	public BookInfoV selectIsbnV(Connection conn, String isbn) throws SQLException {
		BookInfoV books = null;
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books"
				+ " where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			books = new BookInfoV();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			
		}
		return books;
	}
	
	//6. View를 위한 책 제목으로 검색
	public List<BookInfoV> selectTitleV(Connection conn, String title) throws SQLException {
		List<BookInfoV> list = new ArrayList<>();
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfoV books = new BookInfoV();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			list.add(books);
			
		}
		return list;
	}
	
	//View를 위한 등록된 책 목록 전체 조회
	public List<BookInfoV> selectAllV(Connection conn) throws SQLException {
		List<BookInfoV> list = new ArrayList<>();
		String sql = "select isbn,"
						+ " link,"
						+ " title,"
						+ " publisher,"
						+ " author,"
						+ " pubdate,"
						+ " price,"
						+ " discount,"
						+ " image,"
						+ " description,"
						+ " category,"
						+ " memo,"
						+ " star,"
						+ " private_memo,"
						+ " reading,"
						+ " read_date"
				+ " from books";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfoV books = new BookInfoV();
			books.setIsbn(rs.getString("isbn"));
			books.setLink(rs.getString("link"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getString("price"));
			books.setDiscount(rs.getString("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getString("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getString("star"));
			books.setPrivateMemo(rs.getString("private_memo"));
			books.setReading(rs.getString("reading"));
			books.setReadDate(rs.getString("read_date"));
			list.add(books);
		}
		return list;
	}
	
	//DTO없이 조회하기
		public List<Map<String, Object>> selectAllMap(Connection conn){
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			try {
				String sql = "select * from books order by 1";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("isbn", rs.getString("isbn"));
					map.put("link", rs.getString("link"));
					map.put("title", rs.getString("title"));
					map.put("publisher", rs.getString("publisher"));
					map.put("author", rs.getString("author"));
					map.put("pubdate", rs.getString("pubdate"));
					map.put("price", rs.getString("price"));
					map.put("discount", rs.getString("discount"));
					map.put("image", rs.getString("image"));
					map.put("description", rs.getString("description"));
					map.put("category", rs.getString("category"));
					map.put("memo", rs.getString("memo"));
					map.put("star", rs.getString("star"));
					map.put("privateMemo", rs.getString("private_memo"));
					map.put("reading", rs.getString("reading"));
					map.put("readDate", rs.getString("read_date"));
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

}
