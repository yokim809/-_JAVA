package oop4;
 
class Final{
  // 1) 객체 생성해야 사용 가능, 값 변경 가능, 가장 많이 사용, instance 변수
  private String normal = "가을 단풍 여행 접수"; 
  
  // 2) 객체 생성 안해도 사용 가능, 값 변경 가능, 간편 사용, 변수 공유
  public static int COUNT = 0;   
  
  // 3) 객체 생성해야 사용 가능, 최초 값 변경 불가능, 상수 선언 
  public final String com = "(주)행복 여행사";
 
  // 4) 객체 생성 안해도 사용 가능, 최초 값 변경 불가능, 상수 선언, 변수 공유 목적
  // public static final String TEL = "☎ 02-1111-1111";  
  public final static String TEL = "☎ 02-1111-1111";
  
  // private 변수의 값 리턴
  public String getNormal(){
    return this.normal;
  }
  
  // private 변수에 값 저장
  public void setNormal(String normal) {
    this.normal = normal;
  }
}
 
public class FinalTest {
  public static void main(String[] args) {
    Final obj = new Final();
    // System.out.println("제목: " + obj.normal); // ERROR
    System.out.println("제목: " + obj.getNormal());
    
    obj.setNormal("서산 튜울립 축제");
    System.out.println("제목: " + obj.getNormal());
    
    Final.COUNT++;
    System.out.println("현재 인원: " + Final.COUNT);
    
    //obj.com = "(주)투어"; // The final field Final.com cannot be assigned final 변수는 한번 할당하면 변경 불가능하다.
    System.out.println("여행사: " + obj.com);
    System.out.println("연락처: " + Final.TEL);
  }
 
}