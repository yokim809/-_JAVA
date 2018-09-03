package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataProc {

  public static void main(String[] args) {
    File src = new File("C:/ai3/io/data.csv");
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
        String line = br.readLine(); // 왕눈이,80,90,100
        if (line == null) { // 파일 마지막인지 검사
          break;
        } else {
          System.out.println(line); // 화면 출력
          
          String[] values = line.split(",");
          String name = values[0];
          int java = Integer.parseInt(values[1]);
          int html = Integer.parseInt(values[2]);
          int css3 = Integer.parseInt(values[3]);
          
          int tot = java + html + css3;
          int avg = tot/3;
          
          pw.print(name);              // 파일 기록
          pw.print("\t\t" + java);           
          pw.print("\t\t" + html);           
          pw.print("\t\t" + css3);          
          pw.print("\t\t" + tot);          
          pw.print("\t\t" + avg);
          pw.print("\n");           
          
          
          
          
          
          
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
