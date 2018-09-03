package oop;

public class Range {
  
  public int calc(int num1,int num2) {
    
    int range =0;
    
    range = num1 -num2;
    
    if(range<0) {
      range = num2-num1;
    }
    
    return range;
  }
  
}
