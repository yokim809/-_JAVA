package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class DataProc3 {

  public static void main(String[] args) {
    File src = new File("C:/ai3/io/pay.csv");
    File dest = new File("C:/ai3/io/data_proc.txt");
    
    //File -> FileReader -> BufferedReader
    FileReader reader = null; // ���� �б�
    BufferedReader br = null; // ���� ������ �޸𸮿� ����

    // PrintWriter -> FileWriter -> File
    FileWriter writer = null; // ���Ͽ� ���
    PrintWriter pw = null; //  �޸𸮿� ���
    
    try {
      reader = new FileReader(src); // Call By Reference, �ؽ��ڵ� ����
      br = new BufferedReader(reader); // Call By Reference, �ؽ��ڵ� ����
      
      // false : ���� ������ ����� ���, true : ���� �ϴܿ� �߰�
      writer = new FileWriter(dest,false);
      pw = new PrintWriter(writer); //
      
      while(true) {
        String line = br.readLine(); //
        if (line == null) { // ���� ���������� �˻�
          break;
        } else {
          DecimalFormat df = new DecimalFormat("#,###,###");
          
          String[] values = line.split(",");
          String name =  values[0];
          String basic = df.format(Integer.parseInt(values[1]));
          int career =Integer.parseInt(values[2]);
          String incentive = df.format(career*200000);
          String pay = df.format(Integer.parseInt(values[1]) + (career*200000));
          String yearPay = df.format((Integer.parseInt(values[1]) + (career*200000))*13);
          System.out.println("����: " + name);
          System.out.println("�⺻��: " + basic  + "��");
          System.out.println("���: " + career + "��");
          System.out.println("����: " +  incentive + "��");
          System.out.println("�޿�: " + pay + "��" );
          System.out.println("����: " +  yearPay +"��");
          System.out.println("----------------------");
          
          
   
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
