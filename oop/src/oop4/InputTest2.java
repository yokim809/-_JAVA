package oop4;
 
import java.util.Scanner;
 
public class InputTest2 {
 
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("사원 번호: ");
    //int sano = scan.nextInt(); // 정수
    
     int sano = Integer.parseInt(scan.nextLine()); // 정수
    
    System.out.print("희망 직무: ");
    String job = scan.nextLine(); // 문장 입력
    
    System.out.println(sano);
    System.out.println(job);
 
  }
 
}
 