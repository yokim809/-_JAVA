package oop5;
 
public class Pay2015 extends Payment {
 
  @Override //추상메소드를 구현했다는 표식을 의미함(생략 가능)
  public void card() {
    System.out.println("신용 카드 결재 2.5%");
  }
 
  @Override //추상메소드를 구현했다는 표식을 의미함.
  public void mobile() {
    System.out.println("휴대폰 결재 300 원");
  }
 
}