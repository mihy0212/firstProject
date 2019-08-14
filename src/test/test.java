package test;



public class test {

	public static void main(String[] args) {
		
		NaverBookService service = new NaverBookService();
        for(Book b : service.searchBook("java", 20, 1))
            System.out.println(b);
		
    }

}
