package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
 
public class AlbaProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/alba.csv");
    File dest = new File("C:/ai3/io/alba_proc.txt");
    
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
        String line = br.readLine(); // 내장산,2016-11-10,50000,4,0
        if (line == null) { // 파일 마지막인지 검사
          break; // while 탈출
        } else {
          System.out.println(line); // 화면 출력
          
/*
성명: 아로미
근무 시간: 50 시간
근무 유형: 주간
기본급: 376,500 원
초과 수당: 0 원      
야간 수당: 0 원
총금액: 376,500 원
 
아로미,50     ,A
*/
          String[] values = line.split(",");
          
          String name = values[0].trim(); // 성명
          int time = Integer.parseInt(values[1].trim()); // 근무 시간
          String type = values[2].trim(); // 타입
          
          int basic = time * 7530;
          
          // 초과 수당
          int over_time = 0;
          if (time >= 70 && time <= 79) {
            over_time = 50000;
          } else if (time >= 80) {
            over_time = 100000;
          }
          
          // 야간 수당
          int night = 0;
          if (type.equals("B")) {
            night = 100000;
          }
          
          int total = basic + over_time + night;
          
          DecimalFormat df = new DecimalFormat("#,###,### 원");
          
          pw.println("성명: " + name);  // 파일 기록
          pw.println("근무시간: " + time);
          pw.println("근무유형: " + type); 
          pw.println("기본급: " + df.format(basic));
          pw.println("초과 수당: " + df.format(over_time));
          pw.println("야간 수당: " + df.format(night));
          pw.println("총금액: " + df.format(total));
          pw.println("-------------------------------");
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