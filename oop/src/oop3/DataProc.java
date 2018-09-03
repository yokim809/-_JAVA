package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataProc {

  public static void main(String[] args) {
    File src = new File("C:/ai3/io/data.csv");
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
        String line = br.readLine(); // �մ���,80,90,100
        if (line == null) { // ���� ���������� �˻�
          break;
        } else {
          System.out.println(line); // ȭ�� ���
          
          String[] values = line.split(",");
          String name = values[0];
          int java = Integer.parseInt(values[1]);
          int html = Integer.parseInt(values[2]);
          int css3 = Integer.parseInt(values[3]);
          
          int tot = java + html + css3;
          int avg = tot/3;
          
          pw.print(name);              // ���� ���
          pw.print("\t\t" + java);           
          pw.print("\t\t" + html);           
          pw.print("\t\t" + css3);          
          pw.print("\t\t" + tot);          
          pw.print("\t\t" + avg);
          pw.print("\n");           
          
          
          
          
          
          
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