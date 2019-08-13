package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;
import co.kkomang.app.model.Users;

public class BookDAO {
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	//싱글톤
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	
	//등록
	public void insert(Connection conn, BookInfo book) throws SQLException {
		String sql = "insert into books (isbn,"
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
				+ " read_date,"
				+ " choice_where)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, book.getIsbn());
		pstmt.setString(2, book.getTitle());
		pstmt.setString(3, book.getPublisher());
		pstmt.setString(4, book.getAuthor());
		pstmt.setString(5, book.getPubdate());
		pstmt.setInt(6, book.getPrice());
		pstmt.setInt(7, book.getDiscount());
		pstmt.setString(8, book.getImage());
		pstmt.setString(9, book.getDescription());
		pstmt.setInt(10, book.getCategory());
		pstmt.setString(11, book.getMemo());
		pstmt.setInt(12, book.getStar());
		pstmt.setInt(13, book.getPrivateMemo());
		pstmt.setInt(14, book.getReading());
		pstmt.setString(15, book.getReadDate());
		pstmt.setInt(16, book.getChoiceWhere());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 등록 완료");
	}
	
	//수정
	public void update(Connection conn, BookInfo book) throws SQLException {
		String sql = "insert books  set title=?,"
				+ " publisher=?,"
				+ " author=?,"
				+ " pubdate=?,"
				+ " price=?,"
				+ " discount=?,"
				+ " image=?,"
				+ " description=?,"
				+ " category=?,"
				+ " memo=?,"
				+ " star=?,"
				+ " private_memo=?,"
				+ " reading=?,"
				+ " read_date=?,"
				+ " choice_where=?"
				+ " where set isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getPublisher());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getPubdate());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscount());
		pstmt.setString(7, book.getImage());
		pstmt.setString(8, book.getDescription());
		pstmt.setInt(9, book.getCategory());
		pstmt.setString(10, book.getMemo());
		pstmt.setInt(11, book.getStar());
		pstmt.setInt(12, book.getPrivateMemo());
		pstmt.setInt(13, book.getReading());
		pstmt.setString(14, book.getReadDate());
		pstmt.setInt(15, book.getChoiceWhere());
		pstmt.setInt(16, book.getIsbn());
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 수정 완료");
	}
	
	//삭제
	public void delete(Connection conn, String isbn) throws SQLException {
		String sql = "delete from books where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건 삭제 완료");
	}
	
	//한 건 조회 : ISBN으로 조회
	public BookInfo selectOneIsbn(Connection conn, String isbn) throws SQLException {
		BookInfo books = null;
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			books = new BookInfo();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
			
		}
		return books;
	}
	
	//책 제목으로 검색
	public List<BookInfo> selectAlltitle(Connection conn, String title) throws SQLException {
		List<BookInfo> list = new ArrayList<>();
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfo books = new BookInfo();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
			list.add(books);
			
		}
		return list;
	}
	
	//전체 조회
	public List<BookInfo> selectAll(Connection conn, String title) throws SQLException {
		List<BookInfo> list = new ArrayList<>();
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfo books = new BookInfo();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
			list.add(books);
		}
		return list;
	}
	
	//View를 위한 한건 조회
	public BookInfoV selectOneV(Connection conn, String isbn) throws SQLException {
		BookInfoV books = null;
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where isbn=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			books = new BookInfoV();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
			
		}
		return books;
	}
	
	//View를 위한 책 제목으로 검색
	public List<BookInfoV> selectAlltitleV(Connection conn, String title) throws SQLException {
		List<BookInfoV> list = new ArrayList<>();
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfoV books = new BookInfoV();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
			list.add(books);
			
		}
		return list;
	}
	
	//View를 위한 전체 조회
	public List<BookInfoV> selectAllV(Connection conn, String title) throws SQLException {
		List<BookInfoV> list = new ArrayList<>();
		String sql = "select isbn,"
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
						+ " read_date,"
						+ " choice_where"
				+ " from books"
				+ " where title=?";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			BookInfoV books = new BookInfoV();
			books.setIsbn(rs.getInt("isbn"));
			books.setTitle(rs.getString("title"));
			books.setPublisher(rs.getString("publisher"));
			books.setAuthor(rs.getString("author"));
			books.setPubdate(rs.getString("pubdate"));
			books.setPrice(rs.getInt("price"));
			books.setDiscount(rs.getInt("discount"));
			books.setImage(rs.getString("image"));
			books.setDescription(rs.getString("description"));
			books.setCategory(rs.getInt("category"));
			books.setMemo(rs.getString("memo"));
			books.setStar(rs.getInt("star"));
			books.setPrivateMemo(rs.getInt("private_memo"));
			books.setReading(rs.getInt("reading"));
			books.setReadDate(rs.getString("read_date"));
			books.setChoiceWhere(rs.getInt("choice_where"));
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
					map.put("isbn", rs.getInt("isbn"));
					map.put("title", rs.getString("title"));
					map.put("publisher", rs.getString("publisher"));
					map.put("author", rs.getString("author"));
					map.put("pubdate", rs.getString("pubdate"));
					map.put("price", rs.getInt("price"));
					map.put("discount", rs.getInt("discount"));
					map.put("image", rs.getString("image"));
					map.put("description", rs.getString("description"));
					map.put("category", rs.getInt("category"));
					map.put("memo", rs.getString("memo"));
					map.put("star", rs.getInt("star"));
					map.put("privateMemo", rs.getInt("private_memo"));
					map.put("reading", rs.getInt("reading"));
					map.put("readDate", rs.getString("read_date"));
					map.put("choiceWhere", rs.getInt("choice_where"));
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

}
