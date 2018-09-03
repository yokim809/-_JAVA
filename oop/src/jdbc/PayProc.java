package jdbc;

import java.util.Scanner;

public class PayProc {
  PayDAO payDAO = null;
  Scanner in = null;
  
  public PayProc() {
    this.payDAO = new PayDAO();
    this.in = new Scanner(System.in);
  }
  
  public void menu() {
    int menu = 0; // ���� ����

    while(true) {
      System.out.println();
      System.out.println("Pay chart(ver 1.0)");
      System.out.println("��������������������");
      System.out.println("      1. ���");
      System.out.println("      2. ���");
      System.out.println("      3. ��ȸ");
      System.out.println("      4. ����");
      System.out.println("      5. ����");
      System.out.println("      9. ����");
      System.out.println("��������������������");
      System.out.print("�޴� �Է�: ");
      menu = Integer.parseInt(in.nextLine()); // ��ȣ �Է�
      System.out.println();

      if (menu == 1) {
        create();
      } else if (menu == 2) {
        list();
      } else if (menu == 3) {
        read();
      } else if (menu == 4) {
        update();   
      } else if (menu == 5) {
        delete();              
      } else if (menu == 9) {
        System.out.println("��ſ� �Ϸ�Ǽ���~~");
        System.exit(0);
      }
    }
  }
  
  public void create() {
    //public void create(String name, int basic, int year, int sudang)
    String name = "";
    int basic = 0;
    int year = 0;
    int sudang = 0;
    
    System.out.print("�̸�: ");
    name = in.nextLine();
    System.out.print("�⺻��: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("���: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("����: ");
    sudang = Integer.parseInt(in.nextLine());
    
    this.payDAO.create(name, basic, year, sudang);
  }
  
  public void list() {
    this.payDAO.list();
  }
  
  public void read() {
    int payno = 0;
    
    System.out.print("��ȸ�� ��ȣ: ");
    payno = Integer.parseInt(in.nextLine());
    
    this.payDAO.read(payno);
  }
  
  public void update() {
    // public void update(int payno, String name, int basic, int year, int sudang) 
    int payno = 0;
    String name = "";
    int basic = 0;
    int year = 0;
    int sudang = 0;
    
    System.out.print("������ ��ȣ: ");
    payno = Integer.parseInt(in.nextLine());
    System.out.print("�̸�: ");
    name = in.nextLine();
    System.out.print("�⺻��: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("���: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("����: ");
    sudang = Integer.parseInt(in.nextLine());
    
    this.payDAO.update(payno, name, basic, year, sudang);
  }
  
  public void delete() {
    int payno = 0;
    
    System.out.print("������ ��ȣ: ");
    payno = Integer.parseInt(in.nextLine());
    
    this.payDAO.delete(payno);
  }
}