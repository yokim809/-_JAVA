package jdbc2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MapleProc {
  DecimalFormat df = new DecimalFormat("�� #,###,###,###��");
  MapleDAO mapleDAO =null;
  Scanner in = null;

  public MapleProc() {
    this.mapleDAO = new MapleDAO();
    this.in = new Scanner(System.in);
  }

  public void menu() {
    int menu = 0; // ���� ����

    while(true) {
      System.out.println();
      System.out.println("Maple chart(ver 2.0)");
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
    // public void create(String mountain, int price, int count)
    MapleVO mapleVO = new MapleVO();
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("������: ");
    mountain = in.nextLine();
    System.out.print("ȸ��: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("�ο���: ");
    count = Integer.parseInt(in.nextLine());
    
    mapleVO.setMountain(mountain);
    mapleVO.setPrice(price);
    mapleVO.setCount(count);
    
    int cnt = this.mapleDAO.create(mapleVO);
    if(cnt == 1) {
      System.out.println("��� ó�� ����");
    } else {
      System.out.println("��� ó�� ����");
    }
  }
  
  public void list() {
    ArrayList<MapleVO> list = this.mapleDAO.list();
    int count = list.size();
    
    for(int i =0; i < count; i++) {
      MapleVO mapleVO = list.get(i);
      System.out.println("������: " + mapleVO.getMountain());
      System.out.println("��¥: " + mapleVO.getMapledate().substring(5,7) +"��" + mapleVO.getMapledate().substring(8, 10) + "��");
      System.out.println("ȸ��: " + df.format(mapleVO.getPrice()));
      System.out.println("�ο���: " + mapleVO.getCount() + "��");
      System.out.println("�ѱݾ�: " + df.format(mapleVO.getTotal()));
      System.out.println("��� ��¥: " +mapleVO.getRdate().substring(0, 10));
      System.out.println("����������������������������������������������������");
    }
  }
  
  public void read() {  
    System.out.print("��ȸ�� ��ȣ: ");
    int mapleno = Integer.parseInt(in.nextLine());
    
    MapleVO mapleVO = this.mapleDAO.read(mapleno);
    
    if(mapleVO != null) {
      System.out.println("������: " + mapleVO.getMountain());
      System.out.println("��¥: " + mapleVO.getMapledate().substring(5,7) +"��" + mapleVO.getMapledate().substring(8, 10) + "��");
      System.out.println("ȸ��: " + df.format(mapleVO.getPrice()));
      System.out.println("�ο���: " + mapleVO.getCount() + "��");
      System.out.println("�ѱݾ�: " + df.format(mapleVO.getTotal()));
      System.out.println("��� ��¥: " +mapleVO.getRdate().substring(0, 10));
      System.out.println("����������������������������������������������������");
    } else {
      System.out.println("��ȸ�Ͻ� ��ȣ�� �����Ͱ� �����ϴ�.");
    }
  }
  
  public void update() {
    // public void update(int mapleno, String mountain, int price, int count)
    MapleVO mapleVO = new MapleVO();
    int mapleno = 0;
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("������ ��ȣ: ");
    mapleno = Integer.parseInt(in.nextLine());
    System.out.print("������: ");
    mountain = in.nextLine();
    System.out.print("ȸ��: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("�ο���: ");
    count = Integer.parseInt(in.nextLine());
    
    mapleVO.setMapleno(mapleno);
    mapleVO.setMountain(mountain);
    mapleVO.setPrice(price);
    mapleVO.setCount(count);
    
    int cnt = this.mapleDAO.update(mapleVO);
    if(cnt == 1) {
      System.out.println("���� ó�� ����");
    } else {
      System.out.println("���� ó�� ����");
    }
  }
  
  public void delete() {
    int mapleno = 0;
    
    System.out.print("������ ��ȣ: ");
    mapleno = Integer.parseInt(in.nextLine());
    
    int count = this.mapleDAO.delete(mapleno);
    if(count == 1) {
      System.out.println("���� ó�� ����");
    } else {
      System.out.println("���� ó�� ����");
    }
  }
}
