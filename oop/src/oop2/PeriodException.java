package oop2;
 
public class PeriodException extends Exception {
  public PeriodException() {
    System.out.println("입력 가능한 연도는 2017 ~ 2023년입니다.");
    
  }
 
  public PeriodException(int year) {
    System.out.println("입력 가능한 연도는 2017 ~ 2023년입니다.");
    System.out.println("입력된 연도: " + year + " 년");
    
  }
  
  
}