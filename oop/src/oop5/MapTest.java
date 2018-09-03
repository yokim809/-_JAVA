package oop5;

import java.util.HashMap;

public class MapTest {

  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put("A01", "Web 개발자"); // key, value
    map.put("A02", "Android 개발자");
    map.put("A03", "Bigdata 분석 전문가");
    
    Object obj = map.get("A01");
    String a01 = (String)obj;
    System.out.println(a01.toLowerCase());
    
    String a02 = (String)map.get("A02");
    System.out.println(a02.toLowerCase());
    
    System.out.println(((String)map.get("A03")).toLowerCase());

    System.out.println();
    
    map.put("2014", 1000000000); // Integer형으로 자동변환
    map.put("2015", 2000000000);
    map.put("2016", 3000000000L); //30억 Long형식
    
    long sale = (int)map.get("2014"); 
    System.out.println(sale + 100000000);
    
    sale = (int)map.get("2015");
    System.out.println((sale + 100000000));
    
    sale = (long)map.get("2016");
    System.out.println(sale + 100000000);
  }

}