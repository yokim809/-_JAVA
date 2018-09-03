package oop4;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class MapleDAO {
  public Maple calc(String line) {
    System.out.println(line); // ȭ�� ���
    
    String[] values = line.split(",");
    String mountain = values[0]; // ��
    String _date = values[1];
    // String str = "2016-11-10";
    // 11�� 10��
    // String date = str.substring(5, 7) + "�� " + str.substring(8, 10) + "��";
    String date = _date.substring(5, 7) + "�� " + _date.substring(8, 10) + "��";
    
    int price = Integer.parseInt(values[2]);
    int count = Integer.parseInt(values[3]);
    int cable = Integer.parseInt(values[4]);
    int cable_price = cable * 12000; 
    int total = (price * count) + cable_price;
    
    Maple maple = new Maple(mountain, date, price, count, cable, cable_price, total);
    
    return maple;
  }
  
  public void print(Maple maple, PrintWriter pw) {
    
    DecimalFormat df = new DecimalFormat("�� #,###,### ��");
    
    pw.println("������: " + maple.mountain);  // ���� ���
    pw.println("��¥: " + maple.date);
    pw.println("ȸ��: " + df.format(maple.price)); 
    pw.println("�ο���: " + maple.count + " ��");
    pw.println("���̺�ī: " + maple.cable + " ��");
    pw.println("���̺�ī �ݾ�: " + df.format(maple.cable_price));
    pw.println("�ѱݾ�: " + df.format(maple.total));
    pw.println("-------------------------------");
  }
}
