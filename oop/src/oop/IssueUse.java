package oop;

public class IssueUse {

  public static void main(String[] args) {
    Issue issue = new Issue();
    
    int pay = issue.payBack(20000);
    System.out.println("������ : 20000 ���� :" + pay);
    pay = issue.payBack(30000);
    System.out.println("��ǳ���� : 30000 ���� :" + pay);
    pay = issue.payBack(25000);
    System.out.println("����3�� : 25000 ���� :" + pay);
    
    System.out.println();
    
    System.out.println("������ : 20000 ���� :" + issue.payBack(20000));
    System.out.println("��ǳ���� : 30000 ���� :" + issue.payBack(30000));
    System.out.println("����3�� : 25000 ���� :" + issue.payBack(25000));

  }

}
