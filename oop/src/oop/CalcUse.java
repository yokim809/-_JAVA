package oop;
 
public class CalcUse {
 
  public static void main(String[] args) {
    Calc calc = new Calc();
    int deposit = calc.deposit(200000, 12);
    System.out.println("1) 20 ����, 12 ����: "+deposit+" ��");
 
    deposit = calc.deposit(300000, 12);
    System.out.println("2) 30 ����, 12 ����: "+deposit+" ��");
 
    int receive = calc.home(150000000);
    System.out.println("3) 1�� 5õ���� ���� ���� ���ɾ�: " + receive + " ��");
    
    receive = calc.home(200000000);
    System.out.println("4) 2��� ���� ���� ���ɾ�: " + receive + " ��");
 
    receive = calc.home(250000000);
    System.out.println("5) 2�� 5õ���� ���� ���� ���ɾ�: " + receive + " ��");
    
    receive = calc.home(350000000);
    System.out.println("6) 3�� 5õ���� ���� ���� ���ɾ�: " + receive + " ��");
  }
 
}