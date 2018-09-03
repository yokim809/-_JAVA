package oop4;
 
public class Movie {
  String name;
  String seat;
  int count;
  int child;
  
  int count_price;
  int child_price;
  int price = 0;
  int total;
  int point;
 
  // 기본 생성자
  public Movie() {
 
  }
 
  public Movie(String name, String seat, int count, int child, int count_price, int child_price, int price, int total,
      int point) {
    this.name = name;
    this.seat = seat;
    this.count = count;
    this.child = child;
    this.count_price = count_price;
    this.child_price = child_price;
    this.price = price;
    this.total = total;
    this.point = point;
  }
 
}