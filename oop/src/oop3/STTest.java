package oop3;
 
import java.util.StringTokenizer;
 
public class STTest {
 
  public static void main(String[] args) {
    String[] list = "��,,����,�ܿ�".split(",");
    System.out.println(list.length);
    
    for (int i = 0; i < list.length; i++) { // 0 ~ 3
      System.out.println(list[i]);
    }
     
    System.out.println("-----------------------------------");    
    
    StringTokenizer st = new StringTokenizer("��,,����,�ܿ�", ",");
    System.out.println(st.countTokens());
    
    while(st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
    
    System.out.println("-----------------------------------");
 
    // 2�� �׷�ȭ
    String menu = "���,����,���/��ġ ���,��ġ ���,�δ� ���";
    StringTokenizer st2 = new StringTokenizer(menu, "/");
    
    while(st2.hasMoreTokens()) {
      String group = st2.nextToken();
      System.out.println(group);
      
      StringTokenizer st3 = new StringTokenizer(group, ",");
      while(st3.hasMoreTokens()) {
        System.out.println("   " + st3.nextToken());
      }
    }
      
  }
}
 