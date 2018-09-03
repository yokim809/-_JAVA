package oop3;

import java.io.File;
import java.io.IOException;

public class FileTest {
  
  public static void main(String[] args) {
    File file = new File("C:/ai3/swiss/sw01.jpg");
    
      if(file.exists()) {
        System.out.println("1) 파일이 존재합니다.");
      } else {
        System.out.println("1) 파일이 존재하지 않습니다.");
      }
     
    System.out.println("2) 순수 파일명: " + file.getName());
    System.out.println("3) 파일크기 : " + file.length());
    System.out.println("4) 절대경로 : " + file.getAbsolutePath());
    
    String path = file.getParent();
    System.out.println("5) 현재 폴더 : " + path);
    
    boolean check = file.isFile();
    System.out.println("6) 파일인지 검사:" + check );
    
    //파일명 변경
    
    File src = new File("C:/ai3/swiss/sw01.jpg");         //원본 파일명
    File dest = new File("C:/ai3/swiss/sw01_x.jpg");    //최종 변경될 파일명
    
    check = src.renameTo(dest);     // src -> dest
    System.out.println("7) 파일명 변경:" + check);
    
    check = dest.delete();
    System.out.println("8) 파일 삭제:" + check );
    
    File file2 = new File("C:/ai3/swiss/sw02.jpg");
    String name = file2.getName().toLowerCase();
    if (name.endsWith(".jpg")||name.endsWith(".png")||name.endsWith(".gif")) {
      System.out.println("9) 이미지 파일입니다.");
    }
    
    File file3 = new File("C:/ai3/io/data.txt");
    
      try {
        System.out.println("10) 파일 생성: " +file3.createNewFile());
      } catch (IOException e) {
        e.printStackTrace();
      }
    
      File src2 = new File("C:/ai3/swiss/sw02.jpg");         //원본 파일명
      File dest2 = new File("C:/ai3/io/sw02.jpg");    //이동될 파일명
      
      check = src2.renameTo(dest2); // 이동
      
      if (check == true) {
        System.out.println("11) 파일이 이동되었습니다.");
      }
    
    
  }

}
