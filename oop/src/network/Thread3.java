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
    Three three1 = new Three("ĳ���� ����"); // ���� ��ü ����
    Thread thread1 = new Thread(three1);    // Thread ��ü ����
    thread1.start(); // Thread ����             
    
    Three three2 = new Three("��� ����"); // ���� ��ü ����
    Thread thread2 = new Thread(three2);    // Thread ��ü ����
    thread2.start(); // Thread ����             
 
    Three three3 = new Three("��ī��Ʈ ����"); // ���� ��ü ����
    Thread thread3 = new Thread(three3);    // Thread ��ü ����
    thread3.start(); // Thread ����  
    
  }
} 