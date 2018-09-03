package oop;

public class SSDMain {

  public static void main(String[] args) {
    SSD ssd = new SSD(); // ssd 객체 생성
    System.out.println(ssd.hashCode()); //.멤버연산자
    //2018699554
    System.out.println(ssd.name);
    System.out.println(ssd.price +  " 원");
    System.out.println(ssd.dc + " 원");
    System.out.println(ssd.cnt + " 개");
    System.out.println("-----------------------");
    ssd.name = "256 GB";
    ssd.price = 70000;
    ssd.dc = ssd.price - 5000;
    ssd.cnt = 2;
    
    System.out.println(ssd.name);
    System.out.println(ssd.price +  " 원");
    System.out.println(ssd.dc + " 원");
    System.out.println(ssd.cnt + " 개");

  }

}
