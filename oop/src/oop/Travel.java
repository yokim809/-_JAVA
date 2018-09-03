package oop;

public class Travel {

  int count =0; //전역 변수,필드,인스턴스 변수
  String title = "나의 집";
 
  public void trip1() {
    String name = "땅끝마을"; // 지역변수
    count ++;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
  }
  public void trip2() {
    String name = "월미도"; // 지역변수
    count ++;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
  }
 
  public void trip3() {
    String name = "남이섬"; // 지역변수
    count =count+1;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
  }
 
  public void trip4() {
    String name = "가평"; // 지역변수
    count =count+1;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
  }
 
  public void trip5() {
    int count =10;
    String name = "강촌"; // 지역변수
    count =count+1;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
  }
  
  public void trip6() {
    int count =10;
    String name = "한계령"; // 지역변수
    count =count+1;
    this.count = this.count+1;
    System.out.println("목적지: "+ name);
    System.out.println("여행수: "+ count);
    System.out.println("여행수: "+ this.count);
  }
  
  public void print() { 
    System.out.println("print() this: "+ this.hashCode());
  }
  
  public void print(String title) {
    System.out.println(title);
    System.out.println(this.title);
    
    this.title = title; // 전역변수 <- 지역변수 할당
    System.out.println(this.title);
  }
  
}
