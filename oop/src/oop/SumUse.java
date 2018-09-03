package oop;

public class SumUse {

  public static void main(String[] args) {

    Sum sum = new Sum();
    
    int sumnation = 0;
 
    sumnation = sum.hap(10); 
    System.out.println("1부터 10까지의 합: " + sumnation);

  }

}
