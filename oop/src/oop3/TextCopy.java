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
    FileReader reader = null; // 파일 읽기
    BufferedReader br = null; // 읽은 내용을 메모리에 저장

    // PrintWriter -> FileWriter -> File
    FileWriter writer = null; // 파일에 기록
    PrintWriter pw = null; //  메모리에 기록
    
    try {
      reader = new FileReader(file); // Call By Reference, 해시코드 전달
      br = new BufferedReader(reader); // Call By Reference, 해시코드 전달
      
      // false : 기존 내용을 지우고 기록, true : 파일 하단에 추가
      writer = new FileWriter(file_copyed,false);
      pw = new PrintWriter(writer); //
      
      while(true) {
        String line = br.readLine(); // 파일에서 한 라인씩 읽음
        if (line == null) { // 파일 마지막인지 검사
          break;
        } else {
          System.out.println(line); // 화면 출력
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
