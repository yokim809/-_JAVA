package jdbc2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PayProc {
  DecimalFormat df = new DecimalFormat("��#,###,###,###��");
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
      System.out.println("Pay chart(ver 2.0)");
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
    PayVO payVO = new PayVO();

    System.out.print("�̸�: ");
    name = in.nextLine();
    System.out.print("�⺻��: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("���: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("����: ");
    sudang = Integer.parseInt(in.nextLine());

    payVO.setName(name);
    payVO.setBasic(basic);
    payVO.setYear(year);
    payVO.setSudang(sudang);

    int count = this.payDAO.create(payVO);
    if(count == 1) {
      System.out.println("��� ó�� ����");
    } else {
      System.out.println("��� ó�� ����");
    }
  }

  public void list() {
    ArrayList<PayVO> list = this.payDAO.list();
    int count = list.size();

    for(int i = 0; i < count; i++) {
      PayVO payVO = list.get(i);

      System.out.println("����: " + payVO.getName());
      System.out.println("�⺻��: " + df.format(payVO.getBasic()));
      System.out.println("���: " + payVO.getYear() + "��");
      System.out.println("����: " + df.format(payVO.getSudang()));
      System.out.println("�޿�: " + df.format(payVO.getSalary()));
      System.out.println("��ϳ�¥: "+ payVO.getRdate().substring(0, 10));
      System.out.println("����������������������������������������������������");
    }
  }

  public void read() {
    System.out.print("��ȸ�� ��ȣ: ");
    int payno = Integer.parseInt(in.nextLine());
    
    PayVO payVO = this.payDAO.read(payno);
    
    if(payVO != null) {
      System.out.println("����: " + payVO.getName());
      System.out.println("�⺻��: " + df.format(payVO.getBasic()));
      System.out.println("���: " + payVO.getYear() + "��");
      System.out.println("����: " + df.format(payVO.getSudang()));
      System.out.println("�޿�: " + df.format(payVO.getSalary()));
      System.out.println("��ϳ�¥: "+ payVO.getRdate().substring(0, 10));
      System.out.println("����������������������������������������������������");
    } else {
      System.out.println("��ȸ�Ͻ� ��ȣ�� ������ �����ϴ�.");
    }


  }

  public void update() {
    // public void update(int payno, String name, int basic, int year, int sudang) 
    PayVO payVO = new PayVO();
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
    
    payVO.setPayno(payno);
    payVO.setName(name);
    payVO.setBasic(basic);
    payVO.setYear(year);
    payVO.setSudang(sudang);

    int count = this.payDAO.update(payVO);
    if(count == 1) {
      System.out.println("���� ó�� ����");
    } else {
      System.out.println("���� ó�� ����");
    }
  }

  public void delete() {
    int payno = 0;

    System.out.print("������ ��ȣ: ");
    payno = Integer.parseInt(in.nextLine());

    int count = this.payDAO.delete(payno);
    if(count == 1) {
      System.out.println("���� ����");
    } else {
      System.out.println("���� ����");
    }
  }
}