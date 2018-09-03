package network;
 
public class Thread4 {
 
  public static void main(String[] args) {
    int minute = 0;
    int second = 0;
    
    while(true) {
      try {
        Thread.sleep(1);
        second++;
        System.out.println("현재 경과된 시험 시간: " + minute + " 분" + second + " 초");
        
        if ( second == 60) {
          minute = minute + 1;
          second = 0;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
 
  }
 
}
 