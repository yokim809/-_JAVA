package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
 
public class MapleProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/maple.csv");
    File dest = new File("C:/ai3/io/maple_proc.txt");
    
    // File -> FileReader -> BufferedReader
    FileReader reader = null;   // ���� �б�
    BufferedReader br = null; // ���� ������ �޸𸮿� ����
 
    // PrintWriter -> FileWriter -> File
    FileWriter writer = null;    // ���Ͽ� ���
    PrintWriter pw = null;      // �޸𸮿� ���
    
    try {
      reader = new FileReader(src);      // Call By Reference, �ؽ��ڵ� ����
      br = new BufferedReader(reader); // Call By Reference, �ؽ��ڵ� ����
      
      // false: ���� ������ ����� ���, true: ���� �ϴܿ� �߰�
      writer = new FileWriter(dest, false);  
      pw = new PrintWriter(writer);
      
      while(true) {
        String line = br.readLine(); // �����,2016-11-10,50000,4,0
        if (line == null) { // ���� ���������� �˻�
          break; // while Ż��
        } else {
          System.out.println(line); // ȭ�� ���
          
/*
������: �����
��¥: 11 �� 10 ��
ȸ��: �� 50,000 ��
�ο���: 4 ��
���̺�ī: 0 ��
���̺�ī �ݾ�: �� 0 ��
�ѱݾ�: �� 200,000 ��
 
�����,2016-11-10,50000,4,0
*/
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
          
          DecimalFormat df = new DecimalFormat("�� #,###,### ��");
          
          pw.println("������: " + mountain);  // ���� ���
          pw.println("��¥: " + date);
          pw.println("ȸ��: " + df.format(price)); 
          pw.println("�ο���: " + count + " ��");
          pw.println("���̺�ī: " + cable + " ��");
          pw.println("���̺�ī �ݾ�: " + df.format(cable_price));
          pw.println("�ѱݾ�: " + df.format(total));
          pw.println("-------------------------------");
        }
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        pw.close();
        writer.close();
        br.close();
        pw.close();
      } catch (IOException e) {
      }
    }
  }
 
}