package oop2;
 
public class Ex4Use {
 
  public static void main(String[] args) {
    Ex4 ex4 = new Ex4();
    // ex4.calc(210,  0);
    
    try {
      // try ������ �޼ҵ带 ȣ���ϸ� throws�� ���
      // �ڵ����� ���ܰ� ���޵Ǿ� ����.
      ex4.calc(210,  0);
    } catch (Exception e) {
      System.out.println("�� Ex4Use���� ���� ����.");
      e.printStackTrace();  // ���� ����
    }
    System.out.println("������ ��ƾ ���� ����");
    System.out.println("----------------------------------------------");
 
    try {
      ex4.calc2(230,  0);
    } catch (Exception e) {
      System.out.println("�� Ex4Use���� ���� ����.");
      e.printStackTrace();
    }
    System.out.println("������ ��ƾ ���� ����");
    System.out.println("----------------------------------------------");
  
  }
 
}