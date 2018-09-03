package network;
 
class One{
  private String name;
  
  public One(String name){
    this.name = name;
  }
  
  public void run(){
    for (int i=0 ;i<5; i++){
      System.out.println(i + ": " + name);
    }
  }
}
 
public class Thread1 {
 
  public static void main(String[] args) {
    One one1 = new One("캐리어 공격");
    one1.run();
 
    One one2 = new One("드라군 공격");
    one2.run();
    
    One one3 = new One("스카우트 공격");
    one3.run();
 
  }
}