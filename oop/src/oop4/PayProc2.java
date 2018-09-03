package oop4;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class PayProc2 {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/pay.csv");
    File dest = new File("C:/ai3/io/pay_proc2.txt");
    
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
      
      PayDAO payDAO = new PayDAO();
      while(true) {
        String line = br.readLine(); // �մ���,1800000,1
        if (line == null) { // ���� ���������� �˻�
          break; // while Ż��
        } else {
          Pay pay = payDAO.calc(line);
          payDAO.print(pay, pw);
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
 