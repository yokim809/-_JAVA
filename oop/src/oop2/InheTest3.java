package oop2;
 
class BookStore{
  public void print(){
    System.out.println("�ι� ���� å�� �ֹ��մϴ�.");
  }
}
 
class Java extends BookStore{
  // ��� ���õǰ� ȣ���.
  @Override 
  public void print(){
    System.out.println("JAVA å�� �ֹ��մϴ�.");
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