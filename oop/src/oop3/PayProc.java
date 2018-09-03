package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class PayProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/pay.csv");
    File dest = new File("C:/ai3/io/pay_proc.txt");
    
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
        String line = br.readLine(); // �մ���,1800000,1
        if (line == null) { // ���� ���������� �˻�
          break; // while Ż��
        } else {
          System.out.println(line); // ȭ�� ���
          
          /*
           ����: �մ���
           �⺻��: 1800000 ��
           ���: 1 ��
           ����: 200000 ��
           �޿�: 2000000 ��
           ���: 26000000 ��
           */
          String[] values = line.split(",");
          String name = values[0];
          int basic = Integer.parseInt(values[1]); // �⺻��
          int year = Integer.parseInt(values[2]);
          int sudang = year * 200000; // ����
          int salary = basic + sudang; // �޿�
          int total = salary * 13;  // ����
          
          pw.println("����: " + name);  // ���� ���
          pw.println("�⺻��: " + basic + " ��");
          pw.println("���: " + year + " ��"); 
          pw.println("����: " + sudang + " ��");
          pw.println("�޿�: " + salary + " ��");
          pw.println("����: " + total + " ��");
          pw.println("----------------------");
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
 