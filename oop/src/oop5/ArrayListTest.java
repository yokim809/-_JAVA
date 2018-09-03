package oop5;
 
import java.util.ArrayList;
 
public class ArrayListTest {
 
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    //Vector list = new Vector(); // Network 관련 개발에 주로 사용
    list.add("JAVA"); // String -> Object
    list.add(2017); //int -> Integer -> Object
    list.add(1.25); //double -> Double -> Object
    
    //list.get(0);
    
    String study = (String) list.get(0); // Object -> String
    System.out.println(study.toLowerCase());
    
    int year = (int) list.get(1); // Object -> int
    System.out.println(year);
    
    double basic = (double) list.get(2); // Object -> double
    System.out.println(basic);
    
  }
 
}