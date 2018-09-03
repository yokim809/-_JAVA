package oop5;

import java.util.HashMap;

public class MapTest {

  public static void main(String[] args) {
    HashMap map = new HashMap();
    map.put("A01", "Web ������"); // key, value
    map.put("A02", "Android ������");
    map.put("A03", "Bigdata �м� ������");
    
    Object obj = map.get("A01");
    String a01 = (String)obj;
    System.out.println(a01.toLowerCase());
    
    String a02 = (String)map.get("A02");
    System.out.println(a02.toLowerCase());
    
    System.out.println(((String)map.get("A03")).toLowerCase());

    System.out.println();
    
    map.put("2014", 1000000000); // Integer������ �ڵ���ȯ
    map.put("2015", 2000000000);
    map.put("2016", 3000000000L); //30�� Long����
    
    long sale = (int)map.get("2014"); 
    System.out.println(sale + 100000000);
    
    sale = (int)map.get("2015");
    System.out.println((sale + 100000000));
    
    sale = (long)map.get("2016");
    System.out.println(sale + 100000000);
  }

}