package oop;
 
public class RangeUse {
 
  public static void main(String[] args) {
    Range range = new Range();
    int val= range.calc(7, 70);
 
    System.out.println(7);
    System.out.println(70);
    System.out.println("-----");
    System.out.println(val);
 
    System.out.println();
    val= range.calc(70, 7);
 
    System.out.println(70);
    System.out.println(7);
    System.out.println("-----");
    System.out.println(val);
  }
 
}