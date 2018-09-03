package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
 
public class MapleProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/maple.csv");
    File dest = new File("C:/ai3/io/maple_proc.txt");
    
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
목적지: 내장산
날짜: 11 월 10 일
회비: ￦ 50,000 원
인원수: 4 명
케이블카: 0 명
케이블카 금액: ￦ 0 원
총금액: ￦ 200,000 원
 
내장산,2016-11-10,50000,4,0
*/
          String[] values = line.split(",");
          String mountain = values[0]; // 산
          String _date = values[1];
          // String str = "2016-11-10";
          // 11월 10일
          // String date = str.substring(5, 7) + "월 " + str.substring(8, 10) + "일";
          String date = _date.substring(5, 7) + "월 " + _date.substring(8, 10) + "일";
          
          int price = Integer.parseInt(values[2]);
          int count = Integer.parseInt(values[3]);
          int cable = Integer.parseInt(values[4]);
          int cable_price = cable * 12000; 
          int total = (price * count) + cable_price;
          
          DecimalFormat df = new DecimalFormat("￦ #,###,### 원");
          
          pw.println("목적지: " + mountain);  // 파일 기록
          pw.println("날짜: " + date);
          pw.println("회비: " + df.format(price)); 
          pw.println("인원수: " + count + " 명");
          pw.println("케이블카: " + cable + " 명");
          pw.println("케이블카 금액: " + df.format(cable_price));
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