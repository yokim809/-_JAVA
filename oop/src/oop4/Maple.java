package oop4;

public class Maple {
  
/*  pw.println("������: " + mountain);  // ���� ���
  pw.println("��¥: " + date);
  pw.println("ȸ��: " + df.format(price)); 
  pw.println("�ο���: " + count + " ��");
  pw.println("���̺�ī: " + cable + " ��");
  pw.println("���̺�ī �ݾ�: " + df.format(cable_price));
  pw.println("�ѱݾ�: " + df.format(total));
  pw.println("-------------------------------");*/
  
 
  String mountain;
  String date; 
  
  int price;
  int count;
  int cable;
  int cable_price; 
  int total;
  
  public Maple() {
    
  }

  public Maple(String mountain, String date, int price, int count, int cable, int cable_price, int total) {
    this.mountain = mountain;
    this.date = date;
    this.price = price;
    this.count = count;
    this.cable = cable;
    this.cable_price = cable_price;
    this.total = total;
  }
  
  
  
}
