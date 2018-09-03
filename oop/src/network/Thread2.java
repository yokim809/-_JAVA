package network;
 
class Two extends Thread{
  private String name;
 
  public Two(String name){
    this.name = name;
  }
  
  @Override
  public void run(){
    for (int i=0 ;i<100; i++){
      System.out.println(i + ": " + name);
    }
  }
}
 
public class Thread2 {
 
  public static void main(String[] args) {
    Two one1 = new Two("캐리어 공격");
    one1.start(); // run() 호출됨
 
    Two one2 = new Two("드라군 공격");
    one2.start();
    
    Two one3 = new Two("스카우트 공격");
    one3.start();
 
  }
} 