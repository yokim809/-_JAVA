package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextCopy {

  public static void main(String[] args) {
    File file = new File("C:/ai3/io/news.txt");
    File file_copyed = new File("C:/ai3/io/news.txt.bak");
    
    //File -> FileReader -> BufferedReader
    FileReader reader = null; // ���� �б�
    BufferedReader br = null; // ���� ������ �޸𸮿� ����

    // PrintWriter -> FileWriter -> File
    FileWriter writer = null; // ���Ͽ� ���
    PrintWriter pw = null; //  �޸𸮿� ���
    
    try {
      reader = new FileReader(file); // Call By Reference, �ؽ��ڵ� ����
      br = new BufferedReader(reader); // Call By Reference, �ؽ��ڵ� ����
      
      // false : ���� ������ ����� ���, true : ���� �ϴܿ� �߰�
      writer = new FileWriter(file_copyed,false);
      pw = new PrintWriter(writer); //
      
      while(true) {
        String line = br.readLine(); // ���Ͽ��� �� ���ξ� ����
        if (line == null) { // ���� ���������� �˻�
          break;
        } else {
          System.out.println(line); // ȭ�� ���
          pw.println(line);
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
