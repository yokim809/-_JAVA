package oop4;
 
import java.util.Scanner;
 
public class InputTest {
 
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next(); // 단어 입력
    System.out.println("1) " + str);
    
    int year = scan.nextInt(); // 하나의 정수 입력
    System.out.println("2) " + year);
    
    long sale = scan.nextLong();
    System.out.println("3) " + sale);
    
    float ft = scan.nextFloat(); // f 생략
    System.out.println("4) " + ft);
    
    double db = scan.nextDouble();
    System.out.println("5) " + db);
    
    scan.close();  // 메모리 해제
  }
}