package oop3;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ImageCopy2 {
 
  public static void main(String[] args) {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    String img1 = args[0];  //원본 파일명
    String img2 = args[1];  //저장될 파일명
    
    try {
      fis = new FileInputStream("C:/ai3/swiss/" + img1);  
      fos = new FileOutputStream(img2);
      
      byte[] buffer = new byte[4096]; // 4 KB, 파일을 읽어서 저장할 메모리 공간 정의
      // buffer: 객체
      int len = 0; // 읽은 바이트수
      int readCount = 0; // 읽은 횟수
      
      while(true) {
        len = fis.read(buffer); // Call by Reference, 4 KB를 읽어 buffer 배열에 저장
        if (len == -1) { // 파일 마지막인지 검사
          break;
        } else {
          fos.write(buffer, 0, len); // 읽은 내용, 기록할 시작 위치, 기록할 길이
          readCount++;              // 읽은 횟수 증가 
          
          System.out.print("#"); // #: 4KB
          if (readCount % 20 == 0) {
            System.out.println();
          }
        }
      }
 
      File file = new File(img2);
      if (file.exists()) {
        System.out.println();
        System.out.println(file.getName() + " 파일 복사 완료");
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fis.close();
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
 
}
 