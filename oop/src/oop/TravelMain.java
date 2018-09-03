package oop;
 
public class TravelMain {
 
  public static void main(String[] args) {
    Travel travel = new Travel();
    travel.trip1();
    travel.trip2();
    travel.trip3();
    travel.trip4();
    travel.trip5();
    travel.trip6();

    System.out.println("main() travel: " + travel.hashCode());
    travel.print(); // 객체명으로는 전역변수(필드)와 메소드만 호출 가능하며
                    // 지역변수는 호출(접근 불가능
      
    travel.print("청평사");
 
  }
 
}