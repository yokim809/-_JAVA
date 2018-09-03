package oop4;
 
import java.io.PrintWriter;
 
public class PayDAO {
  public Pay calc(String line) {
    System.out.println(line); // ȭ�� ���
    
    String[] values = line.split(",");
    String name = values[0];
    int basic = Integer.parseInt(values[1]); // �⺻��
    int year = Integer.parseInt(values[2]);
    int sudang = year * 200000; // ����
    int salary = basic + sudang; // �޿�
    int total = salary * 13;  // ����
    
    Pay pay = new Pay(name, basic, year, sudang, salary, total);
    return pay;
  }
  
  public void print(Pay pay, PrintWriter pw) {
    pw.println("����: " + pay.name);  // ���� ���
    pw.println("�⺻��: " + pay.basic + " ��");
    pw.println("���: " + pay.year + " ��"); 
    pw.println("����: " + pay.sudang + " ��");
    pw.println("�޿�: " + pay.salary + " ��");
    pw.println("����: " + pay.total + " ��");
    pw.println("----------------------");
  }
  
}