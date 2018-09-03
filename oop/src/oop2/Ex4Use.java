package oop2;
 
public class Ex4Use {
 
  public static void main(String[] args) {
    Ex4 ex4 = new Ex4();
    // ex4.calc(210,  0);
    
    try {
      // try 문에서 메소드를 호출하면 throws가 없어도
      // 자동으로 예외가 전달되어 잡힘.
      ex4.calc(210,  0);
    } catch (Exception e) {
      System.out.println("▶ Ex4Use에서 예외 잡음.");
      e.printStackTrace();  // 예외 추적
    }
    System.out.println("나머지 루틴 정상 실행");
    System.out.println("----------------------------------------------");
 
    try {
      ex4.calc2(230,  0);
    } catch (Exception e) {
      System.out.println("▷ Ex4Use에서 예외 잡음.");
      e.printStackTrace();
    }
    System.out.println("나머지 루틴 정상 실행");
    System.out.println("----------------------------------------------");
  
  }
 
}