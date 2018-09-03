
public class While1 {

  public static void main(String[] args) {
    int su = 0;
    
    while(true) { // 무한 루틴, 영원히 실행됨 네트워크 서버등에서 사용
      su = su + 1;
      System.out.println(su);
      
      if(su == 5) {
        break; // 인접 순환문(while 문) 종료
      }
    }
    System.out.println("-----------------------");
    su = 0;
    
    while(su <=4) {
      su = su + 1;
      System.out.println(su);
    }

    
    
  }

}
