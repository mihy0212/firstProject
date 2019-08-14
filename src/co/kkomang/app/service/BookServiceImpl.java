package co.kkomang.app.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.kkomang.app.common.DAO;
import co.kkomang.app.model.BookInfo;
import co.kkomang.app.model.BookInfoV;

public class BookServiceImpl {
	
	BookDAO bookDAO = BookDAO.getInstance();
	int rsCode = 0;
	/*
	 * rsCode <결과 코드>
	 * 0 결과값이 넘어가지 않음
	 * 1 결과가 잘 넘어갔음
	 * -1 "이미 사용 중인 아이디입니다. 다른 아이디를 입력해 주세요."
	 * -2 "이미 등록된 이메일입니다. 다른 이메일을 입력해 주세요."
	 * -3 "해당하는 아이디가 없습니다."
	 * -4 "이미 등록된 책입니다."
	 * -5 "미등록된 책입니다."
	 * -9 DB 접속하지 못함.
	 */
	
	private static BookServiceImpl instance = new BookServiceImpl();
	public static BookServiceImpl getInstance() {
		return instance;
	}
	
	//책정보 등록
	public int insert(BookInfo book) {
		Connection conn = DAO.getConnect();
		try {
			conn.setAutoCommit(false);
			//isbn 중복체크
			BookInfo bookIsbn = bookDAO.selectIsbn(conn, book.getIsbn());
			if(bookIsbn != null) {
				rsCode = -4;
				System.out.println("이미 등록된 책입니다.");
				return rsCode;
			}
			bookDAO.insert(conn, book);
			rsCode = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
	}
	
	//책 정보 수정
	public int update(BookInfo book) {
		Connection conn = DAO.getConnect();
		try {
			conn.setAutoCommit(false);
			//isbn 중복체크
			BookInfo bookIsbn = bookDAO.selectIsbn(conn, book.getIsbn());
			if(bookIsbn == null) {
				rsCode = -5;
				System.out.println("미등록된 책입니다.");
				return rsCode;
			}
			bookDAO.update(conn, book);
			rsCode = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
	}
	
	//책 정보 삭제
	public int delete(String isbn) {
		Connection conn = DAO.getConnect();
		try {
			conn.setAutoCommit(false);
			//isbn이 있는지 확인
			BookInfo bookIsbn = bookDAO.selectIsbn(conn, isbn);
			if(bookIsbn == null) {
				rsCode = -5;
				System.out.println("미등록된 책입니다.");
				return rsCode;
			}
			bookDAO.delete(conn, isbn);
			rsCode = 1;
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			rsCode = -9;
		} finally {
			DAO.close(conn);
		}
		return rsCode;
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
	public BookInfo selectIsbn(String isbn) {
		Connection conn = DAO.getConnect();
		try {
			return bookDAO.selectIsbn(conn, isbn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
	}
	
	//3. 조건별로 책 조회
//	public BookInfo search
	
	//4. 책 목록 전체 조회
	public List<BookInfo> selectAll(){
		Connection conn = DAO.getConnect();
		List<BookInfo> list = null;
		try {
			list = bookDAO.selectAll(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	//5. View를 위한 ISBN으로 책 한 건 조회
	public BookInfoV selectIsbnV(String isbn) {
		Connection conn = DAO.getConnect();
		try {
			return bookDAO.selectIsbnV(conn, isbn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
	}
	
	//8. 책 목록 전체 조회
	public List<BookInfoV> selectAllV(){
		Connection conn = DAO.getConnect();
		List<BookInfoV> list = null;
		try {
			list = bookDAO.selectAllV(conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	
	

}
