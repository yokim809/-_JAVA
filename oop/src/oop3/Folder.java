package oop3;

import java.io.File;

public class Folder {

  public static void main(String[] args) {
    File folder = new File("C:/ai3/test");
    boolean sw = folder.mkdir();
    System.out.println("1. 폴더 생성: " + sw );
    
    folder = new File("C:/ai3/test/korea/seoul/jongro/street1");
    sw = folder.mkdirs();
    System.out.println("2. 폴더 생성: " + sw );
  

    File src = new File("C:/ai3/test");
    File dest = new File("C:/ai3/test2");
    sw = src.renameTo(dest);
    System.out.println("3. 폴더명 변경: " + sw);
      
    // street1 폴더를 삭제하세요.
    folder = new File("C:/ai3/test2/korea/seoul/jongro/street1");
    sw = folder.delete();
    System.out.println("4. 폴더 삭제: " + sw);
    System.out.println("4. 폴더 삭제: " + new File("C:/ai3/test2/korea/seoul/jongro").delete());
    System.out.println("4. 폴더 삭제: " + new File("C:/ai3/test2/korea/seoul").delete());
    System.out.println("4. 폴더 삭제: " + new File("C:/ai3/test2/korea").delete());
    
    System.out.println("5. 파일 목록 출력");
    File swiss = new File("C:/ai3/swiss");
    File[] files = swiss.listFiles(); // 파일 목록 추출
   
    for (int i=0; i<files.length;i++) {
      File file = files[i];
      System.out.println(file.getName() + "(" + file.length() + ")");
    }
    
    //sw06.jpg (210382)
  }
}
