package oop2;
 
public class BookUse {
 
  public static void main(String[] args) {
    Book book = new Book(); // 기본 생성자 호출
    book.print();
    
    book = new Book("자바", 20000, "왕눈이"); //생성자 호출
    book.print();
    
    book.setData("JSP", 25000, "이로미"); //메소드 호출
    book.print();
    
    Book book2 = new Book("MySQL");
    book2.print();
    
    book2.setData("화성 침공");
    book2.print();
  }
 
}