package oop2;
 
public class PeriodException extends Exception {
  public PeriodException() {
    System.out.println("�Է� ������ ������ 2017 ~ 2023���Դϴ�.");
    
  }
 
  public PeriodException(int year) {
    System.out.println("�Է� ������ ������ 2017 ~ 2023���Դϴ�.");
    System.out.println("�Էµ� ����: " + year + " ��");
    
  }
  
  
}