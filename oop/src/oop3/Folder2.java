package oop3;
 
import java.io.File;
 
public class Folder2 {
 
  public static void main(String[] args) {
    Tool tool = new Tool();
    
    File swiss = new File("C:/ai3/swiss");
    File[] files = swiss.listFiles(); // ���� ��� ����
    for (int index=0; index < files.length; index++) {
      File file = files[index]; // �迭���� �ϳ��� File ��ü ����
      // System.out.println(file.getName() + "(" + tool.unit(file.length()) + " )");
      
      String str = tool.unit(file.length());       
      System.out.println(file.getName() + "(" + str + " )");
      
    }
  }
 
}