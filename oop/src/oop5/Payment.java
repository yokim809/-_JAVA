package oop5;
 
public abstract class Payment {
  public void cach() {
    System.out.println("현금 결제");
  }
  
  public abstract void card();    // 추상 메소드 (실체는 없지만 계획은 해놓은 것을 의미)
  public abstract void mobile();  // 추상 메소드
}
