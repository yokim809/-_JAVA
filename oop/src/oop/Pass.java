package oop;

public class Pass {

  public String result(int num1, int num2, int num3) {
    
    String res ="";
    int tot = 0;
    int avg =0;
    
    tot = num1+num2+num3;
    avg = tot/3;
    
    if(avg>=60) {
      res = "�հ�";
    } else if(avg<60) {
      res = "���հ�";
    }
    
    return res;
    
  }
  
}
