package oop2;
 
import java.util.Random;
 
public class RndTest {
 
  public static void main(String[] args) {
    int[] members = {0,0,0,0,0,0,0,0,0,0};
    Random rnd = new Random();
    int index = 0;        // 배열 저장 위치
    int su = 0;            // 하나의 난수
    boolean sw = false; // 동일 여부
    
    while(true) {
      su = rnd.nextInt(30) + 1; // 1 ~ 30
      System.out.println("새로 발생된 난수: " + su);
      
      // 동일한 값이 있는지 검사
      for (int i=0; i<= 9; i++) {
        if (members[i] == su) {
          System.out.println("-> 배열에 존재: " + su);
          sw= true;  // 중복 발생, 존재함
          break;      // for 문 종료
        }
      }
      
      if (sw == false) {
        System.out.println("배열 " + index + "에 새로운 값 저장: " + su);
        members[index] = su;
        index = index + 1;
      }
      
      if (index == 10) {
        break;  // while 문 종료
      }
      sw = false; // 값이 존재하지 않는 경우를 가정, 초기화
    }
    System.out.println();
    for (int i=0; i <= 9; i++) {
      System.out.print(members[i] + " ");
    }
  }
 
}