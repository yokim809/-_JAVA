package oop2;
 

class Book2{  // Object class 자동 상속
// class Book2 extends Object{  // 선언하지 않아도 상속됨으로 권장 아님
//class Book2 extends Object , FIR   //하나의 class 만 상속 가능
//class Book2 extends fIR
}

public class InheTest4 {
  public static void main(String[] args) {
    Book2 book = new Book2();
    System.out.println(book.hashCode());
  }
 
}