package oop4;

public class Maple {
  
/*  pw.println("목적지: " + mountain);  // 파일 기록
  pw.println("날짜: " + date);
  pw.println("회비: " + df.format(price)); 
  pw.println("인원수: " + count + " 명");
  pw.println("케이블카: " + cable + " 명");
  pw.println("케이블카 금액: " + df.format(cable_price));
  pw.println("총금액: " + df.format(total));
  pw.println("-------------------------------");*/
  
 
  String mountain;
  String date; 
  
  int price;
  int count;
  int cable;
  int cable_price; 
  int total;
  
  public Maple() {
    
  }

  public Maple(String mountain, String date, int price, int count, int cable, int cable_price, int total) {
    this.mountain = mountain;
    this.date = date;
    this.price = price;
    this.count = count;
    this.cable = cable;
    this.cable_price = cable_price;
    this.total = total;
  }
  
  
  
}
