package oop2;
 

class Book2{  // Object class �ڵ� ���
// class Book2 extends Object{  // �������� �ʾƵ� ��ӵ����� ���� �ƴ�
//class Book2 extends Object , FIR   //�ϳ��� class �� ��� ����
//class Book2 extends fIR
}

public class InheTest4 {
  public static void main(String[] args) {
    Book2 book = new Book2();
    System.out.println(book.hashCode());
  }
 
}