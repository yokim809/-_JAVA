package oop;

public class PassUse {

  public static void main(String[] args) {
 
   Pass pass  = new Pass();
   
   String res = pass.result(90,100,95);
   System.out.println("평가점수 : 90 100 95 결과 ->" + res);
   
   String res1 = pass.result(50,50,50);
   System.out.println("평가점수 : 50 50 50 결과 ->" + res1);
   

  }

}
