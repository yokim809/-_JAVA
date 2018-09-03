package oop4;
 
import java.io.PrintWriter;
 
public class PayDAO {
  public Pay calc(String line) {
    System.out.println(line); // 화면 출력
    
    String[] values = line.split(",");
    String name = values[0];
    int basic = Integer.parseInt(values[1]); // 기본값
    int year = Integer.parseInt(values[2]);
    int sudang = year * 200000; // 수당
    int salary = basic + sudang; // 급여
    int total = salary * 13;  // 연봉
    
    Pay pay = new Pay(name, basic, year, sudang, salary, total);
    return pay;
  }
  
  public void print(Pay pay, PrintWriter pw) {
    pw.println("성명: " + pay.name);  // 파일 기록
    pw.println("기본급: " + pay.basic + " 원");
    pw.println("경력: " + pay.year + " 년"); 
    pw.println("수당: " + pay.sudang + " 원");
    pw.println("급여: " + pay.salary + " 원");
    pw.println("연봉: " + pay.total + " 원");
    pw.println("----------------------");
  }
  
}