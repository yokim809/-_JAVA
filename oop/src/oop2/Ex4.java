package oop2;
 
public class Ex4 {
  public void calc(int tot, int cnt) {
    int avg = tot / cnt;
    
    System.out.println("avg: " + avg);
  }
  
  
  //���� �޼ҵ忡�� ���ܸ� ó������ �ʰ�,
  //���� �߻��� ȣ���� ������ ����
  public void calc2(int tot, int cnt) throws Exception {
    int avg = tot / cnt;
    
    System.out.println("avg: " + avg);
  }
}