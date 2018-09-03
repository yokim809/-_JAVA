package oop4;

public class Employee2Use {

  public static void main(String[] args) {
    Employee2 emp = new Employee2("왕눈이", 68, 75, 89);  // 객체 생성

    //처리 로직 구현 권장하지 않음
    //emp.name = "아로미"; //The field Employee2.name is not visible
    //emp.tot = emp.java + emp.web + emp.dbms;

    emp.calc();

    // System.out.println("성명: " + emp.name);
    emp.print();
  }

}
