package oop2;
 
public class ZeroException extends Exception {
  public ZeroException() {
    System.out.println("0은 입력 할 수 없습니다.");
  }
}