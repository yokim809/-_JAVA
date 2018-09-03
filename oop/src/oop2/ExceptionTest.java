package oop2;
 
public class ExceptionTest {
  public void test1() {
    String str = null;
    System.out.println("str: " + str);
    System.out.println("str.length(): " + str.length());
  }
  
  public void test2() {
    try {
      String str = null;
      System.out.println("str: " + str);
      System.out.println("str.length(): " + str.length());
    } catch (Exception e) {
      System.out.println("���� �߻� ���: " + e.toString());
    }
    
    System.out.println("�ý��� ���� ������...");
  }
  
  public void test3() {
    try {
      String str = null;
      System.out.println("str: " + str);
      System.out.println("str.length():" + str.length() );
    } catch (Exception e) {
      
    }
    
    System.out.println("�ý��� ���� ������....");
    
  }
}