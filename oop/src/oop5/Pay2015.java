package oop5;
 
public class Pay2015 extends Payment {
 
  @Override //�߻�޼ҵ带 �����ߴٴ� ǥ���� �ǹ���(���� ����)
  public void card() {
    System.out.println("�ſ� ī�� ���� 2.5%");
  }
 
  @Override //�߻�޼ҵ带 �����ߴٴ� ǥ���� �ǹ���.
  public void mobile() {
    System.out.println("�޴��� ���� 300 ��");
  }
 
}