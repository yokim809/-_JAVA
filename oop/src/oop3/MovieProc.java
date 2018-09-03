package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
 
public class MovieProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/movie.csv");
    File dest = new File("C:/ai3/io/movie_proc.txt");
    
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
��ȭ��: �Ű��Բ�
�¼�: A
���μ�: 2��
�л���: 1��
���� �ݾ�: 22,000 ��
�л� �ݾ�: 8,800 ��
���� �ݾ�: 30,800 ��
����Ʈ(5%): 1,540 ��
 
�Ű��Բ�,A,2,1
*/
          StringTokenizer st = new StringTokenizer(line, ",");
          String name = st.nextToken().trim(); // ��ȭ��
          String seat = st.nextToken().trim(); // �¼�
          int count = Integer.parseInt(st.nextToken().trim()); // ���μ�
          int child = Integer.parseInt(st.nextToken().trim()); // �л���
          
          int count_price = 0; // ���� �ݾ�
          int child_price = 0; // �л� �ݾ�
          int price = 0;  // �¼��� ����
          if (seat.equals("A")) {
            price = 11000;
          } else if (seat.equals("B")) {
            price = 11000;
          } else if (seat.equals("C")) {
            price = 11000;
          }
          count_price = count * price; // ���� �ݾ�
          child_price = child * (int)(price * 0.8); // �л� �ݾ�
          
          int total = count_price + child_price;
          int point = (int)(total * 0.05);
          
          DecimalFormat df = new DecimalFormat("#,###,### ��");
          
          pw.println("��ȭ��: " + name);  // ���� ���
          pw.println("�¼�: " + seat);
          pw.println("���μ�: " + count + "��"); 
          pw.println("�л���: " + child + "��");
          pw.println("���� �ݾ�: " + df.format(count_price));
          pw.println("�л� �ݾ�: " + df.format(child_price));
          pw.println("���� �ݾ�: " + df.format(total));
          pw.println("����Ʈ(5%): " + df.format(point));
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
 