package oop2;
 
public class Ex5 {
 
  public static void main(String[] args) {
    try {
      int year = Integer.parseInt(args[0]);
      int avg = 2017 / year;
      
      String str = null;
      System.out.println(str.toLowerCase());
      
    } catch (NumberFormatException e) {
      System.out.println("정수를 입력하세요. 예) 1 ~ ");
    } catch (ArithmeticException e) {
      System.out.println("0으로 나눌 수 없습니다.");
    } catch (NullPointerException e) {
      System.out.println("객체가 생성되지 않았습니다.");
    } catch (Exception e) {
      System.out.println("예외가 발생했습니다.");
    }
    
    System.out.println("데이터 처리중입니다...");
 
  }
 
}