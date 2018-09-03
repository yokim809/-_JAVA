package oop;

public class IssueUse {

  public static void main(String[] args) {
    Issue issue = new Issue();
    
    int pay = issue.payBack(20000);
    System.out.println("종각역 : 20000 수당 :" + pay);
    pay = issue.payBack(30000);
    System.out.println("영풍문고 : 30000 수당 :" + pay);
    pay = issue.payBack(25000);
    System.out.println("종로3가 : 25000 수당 :" + pay);
    
    System.out.println();
    
    System.out.println("종각역 : 20000 수당 :" + issue.payBack(20000));
    System.out.println("영풍문고 : 30000 수당 :" + issue.payBack(30000));
    System.out.println("종로3가 : 25000 수당 :" + issue.payBack(25000));

  }

}
