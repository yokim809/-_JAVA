package oop4;

public class Employee2Use {

  public static void main(String[] args) {
    Employee2 emp = new Employee2("�մ���", 68, 75, 89);  // ��ü ����

    //ó�� ���� ���� �������� ����
    //emp.name = "�Ʒι�"; //The field Employee2.name is not visible
    //emp.tot = emp.java + emp.web + emp.dbms;

    emp.calc();

    // System.out.println("����: " + emp.name);
    emp.print();
  }

}
