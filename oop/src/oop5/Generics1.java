package oop5;
 
import java.util.ArrayList;
 
public class Generics1 {
 
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("January"); // String -> Object
    list.add("February"); 
    list.add(3); // int ��� --> Integer --> Object  Ÿ������ ��ȯ
    list.add("April");
    list.add(5); // int ��� --> Integer --> Object  Ÿ������ ��ȯ
    
    for(int index = 0 ; index < list.size() ; index++) {
      String str = (String)list.get(index);
      System.out.println(str);
    }
 
  }
 
}
 