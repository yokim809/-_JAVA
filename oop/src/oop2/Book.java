 package oop2;
 
public class Book {
  String name = "����";  // �ʵ�
  int price = 12000;
  String author = "�Ҽ�";
 
  public Book() { // �⺻ ������ , ���� ����
    name = "������";
    price = 0;
    author = "����";
  }
  
  public Book(String name) { // ������
    this.name = name;
  }
  
  public Book(String name, int price, String author) { // ������
    this.name = name;
    this.price = price;
    this.author = author;
  }
  
  public void setData(String name) { //�ʵ忡 �� ����
    this.name = name;
  }
  
  public void setData(String name, int price, String author) { //�ʵ忡 �� ����
    this.name = name;
    this.price = price;
    this.author = author;
  }
  
  public void print() {
    System.out.println(name);
    System.out.println(price + " ��");
    System.out.println(author);
    System.out.println("--------------");
  }
}
 
 