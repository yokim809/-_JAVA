package oop4;

public class EmployeeUse {

  public static void main(String[] args) {
    Employee emp = new Employee();  // 객체 생성
    emp.name = "아로미";
    emp.java = 90;
    emp.web = 100;
    emp.dbms = 85;

    emp.tot = emp.java + emp.web + emp.dbms;
    emp.avg = (emp.tot / 3.0) + 0.5; // 반올림 (double형을 int로 형변환할때 다운캐스팅이 되기때문에

    System.out.println("성명: " + emp.name);
    System.out.println("JAVA: " + emp.java);
    System.out.println("WEB: " + emp.web);
    System.out.println("DBMS: " + emp.dbms);
    System.out.println("총점: " + emp.tot);
    System.out.println("평균: " + (int)emp.avg);

  }

}
