package oop3;

import java.io.File;
import java.io.IOException;

public class FileTest {
  
  public static void main(String[] args) {
    File file = new File("C:/ai3/swiss/sw01.jpg");
    
      if(file.exists()) {
        System.out.println("1) ������ �����մϴ�.");
      } else {
        System.out.println("1) ������ �������� �ʽ��ϴ�.");
      }
     
    System.out.println("2) ���� ���ϸ�: " + file.getName());
    System.out.println("3) ����ũ�� : " + file.length());
    System.out.println("4) ������ : " + file.getAbsolutePath());
    
    String path = file.getParent();
    System.out.println("5) ���� ���� : " + path);
    
    boolean check = file.isFile();
    System.out.println("6) �������� �˻�:" + check );
    
    //���ϸ� ����
    
    File src = new File("C:/ai3/swiss/sw01.jpg");         //���� ���ϸ�
    File dest = new File("C:/ai3/swiss/sw01_x.jpg");    //���� ����� ���ϸ�
    
    check = src.renameTo(dest);     // src -> dest
    System.out.println("7) ���ϸ� ����:" + check);
    
    check = dest.delete();
    System.out.println("8) ���� ����:" + check );
    
    File file2 = new File("C:/ai3/swiss/sw02.jpg");
    String name = file2.getName().toLowerCase();
    if (name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")) {
      System.out.println("9) �̹��� �����Դϴ�.");
    }
    
    File file3 = new File("C:/ai3/io/data.txt");
    
      try {
        System.out.println("10) ���� ����: " +file3.createNewFile());
      } catch (IOException e) {
        e.printStackTrace();
      }
    
      File src2 = new File("C:/ai3/swiss/sw02.jpg");         //���� ���ϸ�
      File dest2 = new File("C:/ai3/io/sw02.jpg");    //�̵��� ���ϸ�
      
      check = src2.renameTo(dest2); // �̵�
      
      if (check == true) {
        System.out.println("11) ������ �̵��Ǿ����ϴ�.");
      }
    
    
  }

}
