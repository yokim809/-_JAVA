package jdbc2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MapleProc {
  DecimalFormat df = new DecimalFormat("￦ #,###,###,###원");
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
      System.out.println("Maple chart(ver 2.0)");
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
    MapleVO mapleVO = new MapleVO();
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("목적지: ");
    mountain = in.nextLine();
    System.out.print("회비: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("인원수: ");
    count = Integer.parseInt(in.nextLine());
    
    mapleVO.setMountain(mountain);
    mapleVO.setPrice(price);
    mapleVO.setCount(count);
    
    int cnt = this.mapleDAO.create(mapleVO);
    if(cnt == 1) {
      System.out.println("등록 처리 성공");
    } else {
      System.out.println("등록 처리 실패");
    }
  }
  
  public void list() {
    ArrayList<MapleVO> list = this.mapleDAO.list();
    int count = list.size();
    
    for(int i =0; i < count; i++) {
      MapleVO mapleVO = list.get(i);
      System.out.println("목적지: " + mapleVO.getMountain());
      System.out.println("날짜: " + mapleVO.getMapledate().substring(5,7) +"월" + mapleVO.getMapledate().substring(8, 10) + "일");
      System.out.println("회비: " + df.format(mapleVO.getPrice()));
      System.out.println("인원수: " + mapleVO.getCount() + "명");
      System.out.println("총금액: " + df.format(mapleVO.getTotal()));
      System.out.println("등록 날짜: " +mapleVO.getRdate().substring(0, 10));
      System.out.println("──────────────────────────");
    }
  }
  
  public void read() {  
    System.out.print("조회할 번호: ");
    int mapleno = Integer.parseInt(in.nextLine());
    
    MapleVO mapleVO = this.mapleDAO.read(mapleno);
    
    if(mapleVO != null) {
      System.out.println("목적지: " + mapleVO.getMountain());
      System.out.println("날짜: " + mapleVO.getMapledate().substring(5,7) +"월" + mapleVO.getMapledate().substring(8, 10) + "일");
      System.out.println("회비: " + df.format(mapleVO.getPrice()));
      System.out.println("인원수: " + mapleVO.getCount() + "명");
      System.out.println("총금액: " + df.format(mapleVO.getTotal()));
      System.out.println("등록 날짜: " +mapleVO.getRdate().substring(0, 10));
      System.out.println("──────────────────────────");
    } else {
      System.out.println("조회하신 번호에 데이터가 없습니다.");
    }
  }
  
  public void update() {
    // public void update(int mapleno, String mountain, int price, int count)
    MapleVO mapleVO = new MapleVO();
    int mapleno = 0;
    String mountain = "";
    int price = 0;
    int count = 0;
    
    System.out.print("수정할 번호: ");
    mapleno = Integer.parseInt(in.nextLine());
    System.out.print("목적지: ");
    mountain = in.nextLine();
    System.out.print("회비: ");
    price = Integer.parseInt(in.nextLine());
    System.out.print("인원수: ");
    count = Integer.parseInt(in.nextLine());
    
    mapleVO.setMapleno(mapleno);
    mapleVO.setMountain(mountain);
    mapleVO.setPrice(price);
    mapleVO.setCount(count);
    
    int cnt = this.mapleDAO.update(mapleVO);
    if(cnt == 1) {
      System.out.println("수정 처리 성공");
    } else {
      System.out.println("수정 처리 실패");
    }
  }
  
  public void delete() {
    int mapleno = 0;
    
    System.out.print("삭제할 번호: ");
    mapleno = Integer.parseInt(in.nextLine());
    
    int count = this.mapleDAO.delete(mapleno);
    if(count == 1) {
      System.out.println("삭제 처리 성공");
    } else {
      System.out.println("삭제 처리 실패");
    }
  }
}
