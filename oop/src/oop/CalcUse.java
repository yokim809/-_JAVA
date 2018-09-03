package oop;
 
public class CalcUse {
 
  public static void main(String[] args) {
    Calc calc = new Calc();
    int deposit = calc.deposit(200000, 12);
    System.out.println("1) 20 만원, 12 개월: "+deposit+" 원");
 
    deposit = calc.deposit(300000, 12);
    System.out.println("2) 30 만원, 12 개월: "+deposit+" 원");
 
    int receive = calc.home(150000000);
    System.out.println("3) 1억 5천만원 주택 연금 수령액: " + receive + " 원");
    
    receive = calc.home(200000000);
    System.out.println("4) 2억원 주택 연금 수령액: " + receive + " 원");
 
    receive = calc.home(250000000);
    System.out.println("5) 2억 5천만원 주택 연금 수령액: " + receive + " 원");
    
    receive = calc.home(350000000);
    System.out.println("6) 3억 5천만원 주택 연금 수령액: " + receive + " 원");
  }
 
}