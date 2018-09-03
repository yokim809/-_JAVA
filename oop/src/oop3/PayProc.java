package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class PayProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/pay.csv");
    File dest = new File("C:/ai3/io/pay_proc.txt");
    
    // File -> FileReader -> BufferedReader
    FileReader reader = null;   // 파일 읽기
    BufferedReader br = null; // 읽은 내용을 메모리에 저장
 
    // PrintWriter -> FileWriter -> File
    FileWriter writer = null;    // 파일에 기록
    PrintWriter pw = null;      // 메모리에 기록
    
    try {
      reader = new FileReader(src);      // Call By Reference, 해시코드 전달
      br = new BufferedReader(reader); // Call By Reference, 해시코드 전달
      
      // false: 기존 내용을 지우고 기록, true: 파일 하단에 추가
      writer = new FileWriter(dest, false);  
      pw = new PrintWriter(writer);
      
      while(true) {
        String line = br.readLine(); // 왕눈이,1800000,1
        if (line == null) { // 파일 마지막인지 검사
          break; // while 탈출
        } else {
          System.out.println(line); // 화면 출력
          
          /*
           성명: 왕눈이
           기본급: 1800000 원
           경력: 1 년
           수당: 200000 원
           급여: 2000000 원
           년봉: 26000000 원
           */
          String[] values = line.split(",");
          String name = values[0];
          int basic = Integer.parseInt(values[1]); // 기본값
          int year = Integer.parseInt(values[2]);
          int sudang = year * 200000; // 수당
          int salary = basic + sudang; // 급여
          int total = salary * 13;  // 연봉
          
          pw.println("성명: " + name);  // 파일 기록
          pw.println("기본급: " + basic + " 원");
          pw.println("경력: " + year + " 년"); 
          pw.println("수당: " + sudang + " 원");
          pw.println("급여: " + salary + " 원");
          pw.println("연봉: " + total + " 원");
          pw.println("----------------------");
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
 