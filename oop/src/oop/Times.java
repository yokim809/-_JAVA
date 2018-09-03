package oop;

public class Times {
  
  public int count(int num) {
    
    int counting = 0;
    for(int i=1; i<=num;i++) {
      if(i%2==0 && i%3==0 && i%4==0) {
        counting = counting+1;
      }
    }
    
    return counting;
  }

}
