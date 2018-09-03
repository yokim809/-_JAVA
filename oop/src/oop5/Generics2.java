package oop5;

import java.util.ArrayList;

public class Generics2 {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("JAVA");
    list.add("HTML5");
    list.add("CSS3");
    //list.add(2017);  //선언된 타입 이외에는 저장이 불가능하다.

    String str = list.get(0);
    System.out.println(str);
    
    ArrayList<Integer> sales = new ArrayList<Integer>();
    // sales.add("매진");
    sales.add(100000000);
    
    int sale =sales.get(0);
    System.out.println(sale);
  }

}