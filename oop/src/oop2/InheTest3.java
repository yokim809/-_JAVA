package oop2;
 
class BookStore{
  public void print(){
    System.out.println("인문 고전 책을 주문합니다.");
  }
}
 
class Java extends BookStore{
  // 상속 무시되고 호출됨.
  @Override 
  public void print(){
    System.out.println("JAVA 책을 주문합니다.");
  }
}
 
public class InheTest3 {
 
  public static void main(String[] args) {
    Java java = new Java();
    java.print();

    BookStore book = new BookStore();
    book.print();
 
  }
 
}