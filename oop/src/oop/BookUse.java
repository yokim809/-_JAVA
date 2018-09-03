package oop;

public class BookUse {

  public static void main(String[] args) {
 
    Book book = new Book();
    
    book.bookName = "자바 프로그래밍 기초";
    book.publisher = "교학사";
    book.bookPrice = 20000;
    book.dc = 10;
    book.dcPrice = (int)(book.bookPrice * (100-book.dc)/100) ;
    
    System.out.println(book.bookName + "   <- 도서명");
    System.out.println(book.publisher + "                  <- 출판사");
    System.out.println(book.bookPrice + "원              <- 가격");
    System.out.println((double)book.dc + "%             <- 할인율");
    System.out.println(book.dcPrice + "원       <- 판매가");
    
    
    

  }

}
