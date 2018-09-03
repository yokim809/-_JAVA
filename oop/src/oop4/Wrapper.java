package oop4;
 
class Winter {
  static String snow; // class 변수
  String rain;          // instance variable
}
 
public class Wrapper {
 
  public static void main(String[] args) {
    Winter.snow = "함박눈";
    // Winter.rain = "";
    System.out.println(Winter.snow);
    
    int price = Integer.parseInt("35000"); // static method
    price = price + 15000;
    System.out.println(price);
    
    String bin = Integer.toBinaryString(2017);
    System.out.println(bin);
    
    Integer itg = new Integer(2017);
    int pre = itg; // JDK 1.5 부터 지원, 객체를 원시 타입에 할당시 값만 자동 추출됨.
    System.out.println(pre);
    
    Integer itg2 = 2019; // 단순 숫자가 객체로 변경됨
    System.out.println(itg2);
    
  }
 
}