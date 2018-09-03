package oop2;

import java.text.DecimalFormat;
import java.util.Random;

public class APITest {

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("#,###,###");
    String str = df.format(1500000);
    System.out.println("1) " + str);
    
    str = new DecimalFormat("#,###,###").format(2000000);
    System.out.println("2) " + str);
    
    System.out.println("3) " + new DecimalFormat("#,###,###").format(2500000));
    
    System.out.println("4) ȸ�� \\ 10,000��");     //4) ȸ�� \ 10,000��
    System.out.println("5) ȸ�� �� 10,000��");      //5) ȸ�� �� 10,000��
    System.out.println("6) ȸ�� \" 10,000��\"");  //6) ȸ�� " 10,000��"
    
    df = new DecimalFormat("�� #,###,###");
    str = df.format(2200000);
    System.out.println("7) " + str);
  
    df = new DecimalFormat("#,###,###");
    str = df.format(2098.567);
    System.out.println("8) " + str);  //2,099
  
    df = new DecimalFormat("#,###.##");
    str = df.format(2098.567);
    System.out.println("9) " + str);  //2,098.57
    
    str = df.format(2500000.567);
    System.out.println("10) " + str);  //2,500,000.57  //������ #�� #.### �� �־ �� ���� �̻��� �ݾ��� �������� ���

    System.out.println("-------------------------------");
    
    Random rnd = new Random();
    for (int i = 0; i<10; i++) {
     int val = rnd.nextInt(5);
     System.out.print(val + " ");  // 0~4
    }
    
    System.out.println();
    
    for (int i = 0; i<10; i++) {
      int val = rnd.nextInt(5) + 1;
      System.out.print(val + " "); // 1~5
     }
    
    System.out.println();
    
    for (int i = 0; i<10; i++) {
      int val = rnd.nextInt(41);
      int val1 = (-1) * rnd.nextInt(41);
      System.out.print(val + val1 + " ");    // -40~40
     }
    
    
    
  }

}
