package oop3;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ImageCopy {
 
  public static void main(String[] args) {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    
    try {
      fis = new FileInputStream("C:/ai3/swiss/sw06.jpg");
      fos = new FileOutputStream("C:/ai3/io/sw06.jpg");
      
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
 
      File file = new File("C:/ai3/io/sw06.jpg");
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