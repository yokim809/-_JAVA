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
    int menu = 0; // 지역 변수

    while(true) {
      System.out.println();
      System.out.println("Pay chart(ver 1.0)");
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
    //public void create(String name, int basic, int year, int sudang)
    String name = "";
    int basic = 0;
    int year = 0;
    int sudang = 0;
    
    System.out.print("이름: ");
    name = in.nextLine();
    System.out.print("기본급: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("경력: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("수당: ");
    sudang = Integer.parseInt(in.nextLine());
    
    this.payDAO.create(name, basic, year, sudang);
  }
  
  public void list() {
    this.payDAO.list();
  }
  
  public void read() {
    int payno = 0;
    
    System.out.print("조회할 번호: ");
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
    
    System.out.print("수정할 번호: ");
    payno = Integer.parseInt(in.nextLine());
    System.out.print("이름: ");
    name = in.nextLine();
    System.out.print("기본급: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("경력: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("수당: ");
    sudang = Integer.parseInt(in.nextLine());
    
    this.payDAO.update(payno, name, basic, year, sudang);
  }
  
  public void delete() {
    int payno = 0;
    
    System.out.print("삭제할 번호: ");
    payno = Integer.parseInt(in.nextLine());
    
    this.payDAO.delete(payno);
  }
}