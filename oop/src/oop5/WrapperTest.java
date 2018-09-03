package oop5;
 
public class WrapperTest {
 
  public static void main(String[] args) {
    int year = 2014;
    Integer year2 = 2015;  // int -> Integer, JDK 1.5+
    int year3 = new Integer("2016"); // Integer -> int  .숫자뿐아니라 다른 메소드등도 사용가능함.
    int year4 = Integer.parseInt("2017");
    
    System.out.println(year);
    System.out.println(year2);
    System.out.println(year3);
    System.out.println(year4);
    
  }
 
}