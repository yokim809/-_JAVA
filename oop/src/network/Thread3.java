package network;
 
class Three implements Runnable{
  private String name;
 
  public Three(String name){
    this.name = name;
  }
  
  @Override
  public void run(){
    for (int i=0 ;i<5; i++){
      System.out.println(i + ": " + name);
    }
  }
}
 
public class Thread3 {
 
  public static void main(String[] args) {
    Three three1 = new Three("캐리어 공격"); // 구현 객체 생성
    Thread thread1 = new Thread(three1);    // Thread 객체 생성
    thread1.start(); // Thread 시작             
    
    Three three2 = new Three("드라군 공격"); // 구현 객체 생성
    Thread thread2 = new Thread(three2);    // Thread 객체 생성
    thread2.start(); // Thread 시작             
 
    Three three3 = new Three("스카우트 공격"); // 구현 객체 생성
    Thread thread3 = new Thread(three3);    // Thread 객체 생성
    thread3.start(); // Thread 시작  
    
  }
} 