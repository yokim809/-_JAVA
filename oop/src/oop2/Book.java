 package oop2;
 
public class Book {
  String name = "지구";  // 필드
  int price = 12000;
  String author = "소설";
 
  public Book() { // 기본 생성자 , 생략 가능
    name = "도서명";
    price = 0;
    author = "저자";
  }
  
  public Book(String name) { // 생성자
    this.name = name;
  }
  
  public Book(String name, int price, String author) { // 생성자
    this.name = name;
    this.price = price;
    this.author = author;
  }
  
  public void setData(String name) { //필드에 값 저장
    this.name = name;
  }
  
  public void setData(String name, int price, String author) { //필드에 값 저장
    this.name = name;
    this.price = price;
    this.author = author;
  }
  
  public void print() {
    System.out.println(name);
    System.out.println(price + " 원");
    System.out.println(author);
    System.out.println("--------------");
  }
}
 
 