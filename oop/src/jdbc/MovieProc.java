package jdbc;

import java.util.Scanner;

public class MovieProc {
  MovieDAO movieDAO = null;
  Scanner in = null;

  public MovieProc() {
    this.movieDAO = new MovieDAO();
    this.in = new Scanner(System.in);
  }

  public void menu() {
    int menu = 0; // 지역 변수

    while(true) {
      System.out.println();
      System.out.println("Movie chart(ver 1.0)");
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
    //public void  create(String title, double good, String name){
    String title = "";
    double good = 0.0;
    String name = "";

    System.out.print("제목: ");
    title = in.nextLine();

    System.out.print("추천(0.0 ~ 10.0): ");
    good = Double.parseDouble(in.nextLine());

    System.out.print("주연: ");
    name = in.nextLine();

    this.movieDAO.create(title, good, name);
  }

  public void list() {
    this.movieDAO.list();
  }

  public void read() {
    System.out.print("조회할 번호: ");
    int movieno = Integer.parseInt(in.nextLine());

    this.movieDAO.read(movieno);
  }

  public void update() {
    //public void  update(int movieno, String title, double good, String name)
    int movieno = 0;
    String title = "";
    double good = 0.0;
    String name = "";
    
    System.out.print("영화번호: ");
    movieno = Integer.parseInt(in.nextLine());

    System.out.print("제목: ");
    title = in.nextLine();

    System.out.print("추천(0.0 ~ 10.0): ");
    good = Double.parseDouble(in.nextLine());

    System.out.print("주연: ");
    name = in.nextLine();

    this.movieDAO.update(movieno, title, good, name);
  }
  
  public void delete() {
    int movieno = 0;
    
    System.out.print("삭제할 영화번호: ");
    movieno = Integer.parseInt(in.nextLine());
    
    this.movieDAO.delete(movieno);
  }
  
  
}