package oop2;
 
public class Payment {
  String name = ""; // ��ǰ��
  int price = 0;       // ����
  int count = 0;      // ����
  int total = 0;       // ���� �ݾ�
  
  public void order(String name, int price, int count) {
    this.name = name;
    this.price = price;
    this.count = count;
  }
  
  public void calc() {
    this.total = this.price * this.count;
    
    System.out.println("��ǰ��: " + name);
    System.out.println("����: " + price);
    System.out.println("����: " + count);
    System.out.println("���� �ݾ�: " + this.total);
  }
}
 
 