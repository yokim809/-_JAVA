package oop4;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class MapleDAO {
  public Maple calc(String line) {
    System.out.println(line); // 화면 출력
    
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
    
    Maple maple = new Maple(mountain, date, price, count, cable, cable_price, total);
    
    return maple;
  }
  
  public void print(Maple maple, PrintWriter pw) {
    
    DecimalFormat df = new DecimalFormat("￦ #,###,### 원");
    
    pw.println("목적지: " + maple.mountain);  // 파일 기록
    pw.println("날짜: " + maple.date);
    pw.println("회비: " + df.format(maple.price)); 
    pw.println("인원수: " + maple.count + " 명");
    pw.println("케이블카: " + maple.cable + " 명");
    pw.println("케이블카 금액: " + df.format(maple.cable_price));
    pw.println("총금액: " + df.format(maple.total));
    pw.println("-------------------------------");
  }
}
