package jdbc2;

import java.util.ArrayList;
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
      System.out.println("Movie chart(ver 2.0)");
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

    MovieVO movieVO = new MovieVO();
    movieVO.setTitle(title);
    movieVO.setGood(good);
    movieVO.setName(name);

    int count = this.movieDAO.create(movieVO);
    
    if(count == 1) {
      System.out.println("등록 처리 성공");
    } else {
      System.out.println("등록 처리 실패");
    }
  }

  public void list() {
    ArrayList<MovieVO> list =  this.movieDAO.list(); //list의 리턴타입 ArrayList<MovieVO>을 타입으로 사용해야한다.
    int count = list.size();

    for(int i = 0; i < count; i++) {
      MovieVO movieVO = list.get(i);

      System.out.print(movieVO.getMovieno()+ ". " );
      System.out.print(movieVO.getTitle() + ": ");
      System.out.print(movieVO.getName());
      System.out.print("(" + movieVO.getGood() +") ");
      System.out.print(movieVO.getRdate().substring(0, 10));
      System.out.println();
      System.out.println("──────────────────────────");
    }
  }

  public void read() {
    System.out.print("조회할 번호: ");
    int movieno = Integer.parseInt(in.nextLine());

    MovieVO movieVO = this.movieDAO.read(movieno);

    if(movieVO != null) {
      System.out.print(movieVO.getMovieno()+ ". " );
      System.out.print(movieVO.getTitle() + ": ");
      System.out.print(movieVO.getName());
      System.out.print("(" + movieVO.getGood() +") ");
      System.out.print(movieVO.getRdate().substring(0, 10));
      System.out.println();
      System.out.println("──────────────────────────");
    } else {
      System.out.println("조회하신 번호에 등록된 영화가 없습니다.");
    }
  }

  public void update() {
    //public void  update(int movieno, String title, double good, String name)
    MovieVO movieVO = new MovieVO();
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

    movieVO.setMovieno(movieno);
    movieVO.setTitle(title);
    movieVO.setGood(good);
    movieVO.setName(name);

    int count = this.movieDAO.update(movieVO);
    if(count == 1) {
      System.out.println("수정 처리 성공");
    } else {
      System.out.println("수정 처리 실패");
    }

  }

  public void delete() {
    int movieno = 0;

    System.out.print("삭제할 영화번호: ");
    movieno = Integer.parseInt(in.nextLine());

    int count = this.movieDAO.delete(movieno);
    if(count == 1) {
      System.out.println("삭제 처리 성공");
    } else {
      System.out.println("삭제 처리 실패");
    }
    
  }


}