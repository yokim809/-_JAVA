package oop4;

public class EmployeeUse {

  public static void main(String[] args) {
    Employee emp = new Employee();  // ��ü ����
    emp.name = "�Ʒι�";
    emp.java = 90;
    emp.web = 100;
    emp.dbms = 85;

    emp.tot = emp.java + emp.web + emp.dbms;
    emp.avg = (emp.tot / 3.0) + 0.5; // �ݿø� (double���� int�� ����ȯ�Ҷ� �ٿ�ĳ������ �Ǳ⶧����

    System.out.println("����: " + emp.name);
    System.out.println("JAVA: " + emp.java);
    System.out.println("WEB: " + emp.web);
    System.out.println("DBMS: " + emp.dbms);
    System.out.println("����: " + emp.tot);
    System.out.println("���: " + (int)emp.avg);

  }

}
