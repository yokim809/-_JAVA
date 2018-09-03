package oop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class DataProc3 {

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
          DecimalFormat df = new DecimalFormat("#,###,###");
          
          String[] values = line.split(",");
          String name =  values[0];
          String basic = df.format(Integer.parseInt(values[1]));
          int career =Integer.parseInt(values[2]);
          String incentive = df.format(career*200000);
          String pay = df.format(Integer.parseInt(values[1]) + (career*200000));
          String yearPay = df.format((Integer.parseInt(values[1]) + (career*200000))*13);
          System.out.println("성명: " + name);
          System.out.println("기본급: " + basic  + "원");
          System.out.println("경력: " + career + "년");
          System.out.println("수당: " +  incentive + "원");
          System.out.println("급여: " + pay + "원" );
          System.out.println("연봉: " +  yearPay +"원");
          System.out.println("----------------------");
          
          
   
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
