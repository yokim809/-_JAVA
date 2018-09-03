package oop3;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
 
public class MovieProc {
 
  public static void main(String[] args) {
    File src = new File("C:/ai3/io/movie.csv");
    File dest = new File("C:/ai3/io/movie_proc.txt");
    
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
영화명: 신과함께
좌석: A
성인수: 2명
학생수: 1명
성인 금액: 22,000 원
학생 금액: 8,800 원
결재 금액: 30,800 원
포인트(5%): 1,540 원
 
신과함께,A,2,1
*/
          StringTokenizer st = new StringTokenizer(line, ",");
          String name = st.nextToken().trim(); // 영화명
          String seat = st.nextToken().trim(); // 좌석
          int count = Integer.parseInt(st.nextToken().trim()); // 성인수
          int child = Integer.parseInt(st.nextToken().trim()); // 학생수
          
          int count_price = 0; // 성인 금액
          int child_price = 0; // 학생 금액
          int price = 0;  // 좌석당 가격
          if (seat.equals("A")) {
            price = 11000;
          } else if (seat.equals("B")) {
            price = 11000;
          } else if (seat.equals("C")) {
            price = 11000;
          }
          count_price = count * price; // 성인 금액
          child_price = child * (int)(price * 0.8); // 학생 금액
          
          int total = count_price + child_price;
          int point = (int)(total * 0.05);
          
          DecimalFormat df = new DecimalFormat("#,###,### 원");
          
          pw.println("영화명: " + name);  // 파일 기록
          pw.println("좌석: " + seat);
          pw.println("성인수: " + count + "명"); 
          pw.println("학생수: " + child + "명");
          pw.println("성인 금액: " + df.format(count_price));
          pw.println("학생 금액: " + df.format(child_price));
          pw.println("결재 금액: " + df.format(total));
          pw.println("포인트(5%): " + df.format(point));
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
 