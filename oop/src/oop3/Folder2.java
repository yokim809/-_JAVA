package oop3;
 
import java.io.File;
 
public class Folder2 {
 
  public static void main(String[] args) {
    Tool tool = new Tool();
    
    File swiss = new File("C:/ai3/swiss");
    File[] files = swiss.listFiles(); // 파일 목록 추출
    for (int index=0; index < files.length; index++) {
      File file = files[index]; // 배열에서 하나의 File 객체 추출
      // System.out.println(file.getName() + "(" + tool.unit(file.length()) + " )");
      
      String str = tool.unit(file.length());       
      System.out.println(file.getName() + "(" + str + " )");
      
    }
  }
 
}