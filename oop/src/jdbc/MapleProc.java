package jdbc;

import java.util.Scanner;

public class MapleProc {
  MapleDAO mapleDAO =null;
  Scanner in = null;

  public MapleProc() {
    this.mapleDAO = new MapleDAO();
    this.in = new Scanner(System.in);
  }

  public void menu() {
    int menu = 0; // 지역 변수

    while(true) {
      System.out.println();
      System.out.println("Maple chart(ver 1.0)");
      System.out.println("──────────");
      System.out.println("      1. 등록");
      System.out.println("      2. 목록");
      System.out.println("      3. 조회");
      System.out.println("      4. 수정");
      System.out.println("      5. 삭제");
      System.out.println("      9. 종료");
      System.out.println("──────────");
      System.out.print("메뉴 입력: ");
      menu = Integer.parseInt(in.nextLine()); // 번호 입력
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
        System.out.println("즐거운 하루되세요~~");
        System.exit(0);
      }
    }
  }
  
  public void create() {
    // public void create(String mountain, int price, int count)
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("목적지: ");
    mountain = in.nextLine();
    System.out.print("회비: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("인원수: ");
    count = Integer.parseInt(in.nextLine());
    
    this.mapleDAO.create(mountain, price, count);
  }
  
  public void list() {
    this.mapleDAO.list();
  }
  
  public void read() {
    int mapleno = 0;
    
    System.out.print("조회할 번호: ");
    mapleno = Integer.parseInt(in.nextLine());
    
    this.mapleDAO.read(mapleno);
  }
  
  public void update() {
    // public void update(int mapleno, String mountain, int price, int count)
    int mapleno = 0;
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("조회할 번호: ");
    mapleno = Integer.parseInt(in.nextLine());
    System.out.print("목적지: ");
    mountain = in.nextLine();
    System.out.println("회비: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("인원수: ");
    count = Integer.parseInt(in.nextLine());
    
    this.mapleDAO.update(mapleno, mountain, price, count);
  }
  
  public void delete() {
    int mapleno = 0;
    
    System.out.print("삭제할 번호: ");
    mapleno = Integer.parseInt(in.nextLine());
    
    this.mapleDAO.delete(mapleno);
  }
}
