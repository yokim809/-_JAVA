package oop;

public class Calc {
  public int deposit(int cash, int month) {
    int getMoney = 0;
    getMoney = cash * month;
    
    return getMoney;
    
  }

 public int home(int housePrice) {
   int houseWage = 0;
   houseWage = (int)((housePrice *0.039) / 12 );
   
   return houseWage;
 }

}