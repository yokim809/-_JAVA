package oop5;

import java.util.ArrayList;

public class Generics2 {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("JAVA");
    list.add("HTML5");
    list.add("CSS3");
    //list.add(2017);  //����� Ÿ�� �̿ܿ��� ������ �Ұ����ϴ�.

    String str = list.get(0);
    System.out.println(str);
    
    ArrayList<Integer> sales = new ArrayList<Integer>();
    // sales.add("����");
    sales.add(100000000);
    
    int sale =sales.get(0);
    System.out.println(sale);
  }

}