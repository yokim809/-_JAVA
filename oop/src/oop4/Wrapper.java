package oop4;
 
class Winter {
  static String snow; // class ����
  String rain;          // instance variable
}
 
public class Wrapper {
 
  public static void main(String[] args) {
    Winter.snow = "�Թڴ�";
    // Winter.rain = "";
    System.out.println(Winter.snow);
    
    int price = Integer.parseInt("35000"); // static method
    price = price + 15000;
    System.out.println(price);
    
    String bin = Integer.toBinaryString(2017);
    System.out.println(bin);
    
    Integer itg = new Integer(2017);
    int pre = itg; // JDK 1.5 ���� ����, ��ü�� ���� Ÿ�Կ� �Ҵ�� ���� �ڵ� �����.
    System.out.println(pre);
    
    Integer itg2 = 2019; // �ܼ� ���ڰ� ��ü�� �����
    System.out.println(itg2);
    
  }
 
}