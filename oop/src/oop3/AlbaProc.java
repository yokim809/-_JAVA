package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
 
public class AlbaProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/alba.csv");
    File dest = new File("C:/ai3/io/alba_proc.txt");
    
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
����: �Ʒι�
�ٹ� �ð�: 50 �ð�
�ٹ� ����: �ְ�
�⺻��: 376,500 ��
�ʰ� ����: 0 ��      
�߰� ����: 0 ��
�ѱݾ�: 376,500 ��
 
�Ʒι�,50     ,A
*/
          String[] values = line.split(",");
          
          String name = values[0].trim(); // ����
          int time = Integer.parseInt(values[1].trim()); // �ٹ� �ð�
          String type = values[2].trim(); // Ÿ��
          
          int basic = time * 7530;
          
          // �ʰ� ����
          int over_time = 0;
          if (time >= 70 && time <= 79) {
            over_time = 50000;
          } else if (time >= 80) {
            over_time = 100000;
          }
          
          // �߰� ����
          int night = 0;
          if (type.equals("B")) {
            night = 100000;
          }
          
          int total = basic + over_time + night;
          
          DecimalFormat df = new DecimalFormat("#,###,### ��");
          
          pw.println("����: " + name);  // ���� ���
          pw.println("�ٹ��ð�: " + time);
          pw.println("�ٹ�����: " + type); 
          pw.println("�⺻��: " + df.format(basic));
          pw.println("�ʰ� ����: " + df.format(over_time));
          pw.println("�߰� ����: " + df.format(night));
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