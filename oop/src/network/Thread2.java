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
    Two one1 = new Two("ĳ���� ����");
    one1.start(); // run() ȣ���
 
    Two one2 = new Two("��� ����");
    one2.start();
    
    Two one3 = new Two("��ī��Ʈ ����");
    one3.start();
 
  }
} 