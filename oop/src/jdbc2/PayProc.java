package jdbc2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class PayProc {
  DecimalFormat df = new DecimalFormat("￦#,###,###,###원");
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
      System.out.println("Pay chart(ver 2.0)");
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
    PayVO payVO = new PayVO();

    System.out.print("이름: ");
    name = in.nextLine();
    System.out.print("기본급: ");
    basic = Integer.parseInt(in.nextLine());
    System.out.print("경력: ");
    year = Integer.parseInt(in.nextLine());
    System.out.print("수당: ");
    sudang = Integer.parseInt(in.nextLine());

    payVO.setName(name);
    payVO.setBasic(basic);
    payVO.setYear(year);
    payVO.setSudang(sudang);

    int count = this.payDAO.create(payVO);
    if(count == 1) {
      System.out.println("등록 처리 성공");
    } else {
      System.out.println("등록 처리 실패");
    }
  }

  public void list() {
    ArrayList<PayVO> list = this.payDAO.list();
    int count = list.size();

    for(int i = 0; i < count; i++) {
      PayVO payVO = list.get(i);

      System.out.println("성명: " + payVO.getName());
      System.out.println("기본급: " + df.format(payVO.getBasic()));
      System.out.println("경력: " + payVO.getYear() + "년");
      System.out.println("수당: " + df.format(payVO.getSudang()));
      System.out.println("급여: " + df.format(payVO.getSalary()));
      System.out.println("등록날짜: "+ payVO.getRdate().substring(0, 10));
      System.out.println("──────────────────────────");
    }
  }

  public void read() {
    System.out.print("조회할 번호: ");
    int payno = Integer.parseInt(in.nextLine());
    
    PayVO payVO = this.payDAO.read(payno);
    
    if(payVO != null) {
      System.out.println("성명: " + payVO.getName());
      System.out.println("기본급: " + df.format(payVO.getBasic()));
      System.out.println("경력: " + payVO.getYear() + "년");
      System.out.println("수당: " + df.format(payVO.getSudang()));
      System.out.println("급여: " + df.format(payVO.getSalary()));
      System.out.println("등록날짜: "+ payVO.getRdate().substring(0, 10));
      System.out.println("──────────────────────────");
    } else {
      System.out.println("조회하신 번호에 정보가 없습니다.");
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
    
    payVO.setPayno(payno);
    payVO.setName(name);
    payVO.setBasic(basic);
    payVO.setYear(year);
    payVO.setSudang(sudang);

    int count = this.payDAO.update(payVO);
    if(count == 1) {
      System.out.println("수정 처리 성공");
    } else {
      System.out.println("수정 처리 실패");
    }
  }

  public void delete() {
    int payno = 0;

    System.out.print("삭제할 번호: ");
    payno = Integer.parseInt(in.nextLine());

    int count = this.payDAO.delete(payno);
    if(count == 1) {
      System.out.println("삭제 성공");
    } else {
      System.out.println("삭제 실패");
    }
  }
}