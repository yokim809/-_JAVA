package oop;

public class Travel {

  int count =0; //���� ����,�ʵ�,�ν��Ͻ� ����
  String title = "���� ��";
 
  public void trip1() {
    String name = "��������"; // ��������
    count ++;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
  }
  public void trip2() {
    String name = "���̵�"; // ��������
    count ++;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
  }
 
  public void trip3() {
    String name = "���̼�"; // ��������
    count =count+1;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
  }
 
  public void trip4() {
    String name = "����"; // ��������
    count =count+1;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
  }
 
  public void trip5() {
    int count =10;
    String name = "����"; // ��������
    count =count+1;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
  }
  
  public void trip6() {
    int count =10;
    String name = "�Ѱ��"; // ��������
    count =count+1;
    this.count = this.count+1;
    System.out.println("������: "+ name);
    System.out.println("�����: "+ count);
    System.out.println("�����: "+ this.count);
  }
  
  public void print() { 
    System.out.println("print() this: "+ this.hashCode());
  }
  
  public void print(String title) {
    System.out.println(title);
    System.out.println(this.title);
    
    this.title = title; // �������� <- �������� �Ҵ�
    System.out.println(this.title);
  }
  
}
