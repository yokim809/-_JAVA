package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataProc2 {

  public static void main(String[] args) {
    File src = new File("C:/ai3/io/pay.csv");
    File dest = new File("C:/ai3/io/data_proc.txt");
    
    //File -> FileReader -> BufferedReader
    FileReader reader = null; // 파일 읽기
    BufferedReader br = null; // 읽은 내용을 메모리에 저장

    // PrintWriter -> FileWriter -> File
    FileWriter writer = null; // 파일에 기록
    PrintWriter pw = null; //  메모리에 기록
    
    try {
      reader = new FileReader(src); // Call By Reference, 해시코드 전달
      br = new BufferedReader(reader); // Call By Reference, 해시코드 전달
      
      // false : 기존 내용을 지우고 기록, true : 파일 하단에 추가
      writer = new FileWriter(dest,false);
      pw = new PrintWriter(writer); //
      
      while(true) {
        String line = br.readLine(); //
        if (line == null) { // 파일 마지막인지 검사
          break;
        } else {
          System.out.println(line); // 화면 출력
         
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
