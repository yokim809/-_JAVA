package oop5;
 
public abstract class Payment {
  public void cach() {
    System.out.println("���� ����");
  }
  
  public abstract void card();    // �߻� �޼ҵ� (��ü�� ������ ��ȹ�� �س��� ���� �ǹ�)
  public abstract void mobile();  // �߻� �޼ҵ�
}
