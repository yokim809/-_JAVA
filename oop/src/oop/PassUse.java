package oop;

public class PassUse {

  public static void main(String[] args) {
 
   Pass pass  = new Pass();
   
   String res = pass.result(90,100,95);
   System.out.println("������ : 90 100 95 ��� ->" + res);
   
   String res1 = pass.result(50,50,50);
   System.out.println("������ : 50 50 50 ��� ->" + res1);
   

  }

}
