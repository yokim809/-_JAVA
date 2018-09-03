package oop;

public class Pass {

  public String result(int num1, int num2, int num3) {
    
    String res ="";
    int tot = 0;
    int avg =0;
    
    tot = num1+num2+num3;
    avg = tot/3;
    
    if(avg>=60) {
      res = "합격";
    } else if(avg<60) {
      res = "불합격";
    }
    
    return res;
    
  }
  
}
