package jdbc2;

import java.util.ArrayList;
import java.util.Scanner;

public class DataProc {
  DataDAO dataDAO = null;
  Scanner in = null;
  
  public DataProc() {
    this.dataDAO = new DataDAO();
    this.in = new Scanner(System.in);
  }

  public void menu() {
    int menu = 0; // 지역 변수

    while(true) {
      System.out.println();
      System.out.println("Data chart(ver 2.0)");
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
    //public void create(String name, int java, int html, int css3, int tot, int avg) {
    String name = "";
    int java, html, css3, tot, avg = 0;
    
    System.out.print("이름: ");
    name = in.nextLine();
    System.out.print("자바성적: ");
    java = Integer.parseInt(in.nextLine());
    System.out.print("html성적: ");
    html = Integer.parseInt(in.nextLine());
    System.out.print("css성적: ");
    css3 = Integer.parseInt(in.nextLine());
    tot = java + html + css3;
    avg = (tot / 3);
    
    DataVO dataVO = new DataVO();
    dataVO.setName(name);
    dataVO.setJava(java);
    dataVO.setHtml(html);
    dataVO.setCss3(css3);
    dataVO.setTot(tot);
    dataVO.setAvg(avg);
    
    int count = this.dataDAO.create(dataVO);    
    
    if(count == 1) {
      System.out.println("등록 처리 성공");
    } else {
      System.out.println("등록 처리 실패");
    }
  }
  
  public void list() {
    ArrayList<DataVO> list = this.dataDAO.list();
    int count = list.size();
    
    for(int i=0; i < count ; i++) {
      DataVO dataVO = list.get(i);
      
      System.out.print(dataVO.getDatano()+ ". ");
      System.out.print(dataVO.getName() + ": ");
      System.out.print(dataVO.getJava() + ",");
      System.out.print(dataVO.getHtml() + ", ");
      System.out.print(dataVO.getCss3() +" ");
      System.out.print("총점: " + dataVO.getTot());
      System.out.print(", 평균: " + dataVO.getAvg());
      System.out.println();
      System.out.println("──────────────────────────");
    }
  }
  
  public void read() {
    System.out.print("데이터번호: ");
    int datano = Integer.parseInt(in.nextLine());
    
    DataVO dataVO =  this.dataDAO.read(datano);
    
    if(dataVO != null) {
      System.out.print(dataVO.getDatano()+ ". ");
      System.out.print(dataVO.getName() + ": ");
      System.out.print(dataVO.getJava() + ",");
      System.out.print(dataVO.getHtml() + ", ");
      System.out.print(dataVO.getCss3() +" ");
      System.out.print("총점: " + dataVO.getTot());
      System.out.print(", 평균: " + dataVO.getAvg());
      System.out.println();
      System.out.println("──────────────────────────");
    } else{
      System.out.println("조회하신 번호에 데이터가 없습니다.");
    }
    

  }
  
  public void update() {
    //public void  update(int datano, String name, int java, int html, int css3, int tot, int avg) {
    DataVO dataVO = new DataVO();
    String name = "";
    int java, html, css3, tot, avg = 0;
    int datano = 0;
    
    System.out.print("데이터번호: ");
    datano = Integer.parseInt(in.nextLine());
    System.out.print("이름: ");
    name = in.nextLine();
    System.out.print("자바성적: ");
    java = Integer.parseInt(in.nextLine());
    System.out.print("html성적: ");
    html = Integer.parseInt(in.nextLine());
    System.out.print("css성적: ");
    css3 = Integer.parseInt(in.nextLine());
    tot = java + html + css3;
    avg = (tot / 3);
    
    dataVO.setDatano(datano);
    dataVO.setName(name);
    dataVO.setJava(java);
    dataVO.setHtml(html);
    dataVO.setCss3(css3);
    dataVO.setTot(tot);
    dataVO.setAvg(avg);
    
    int count = this.dataDAO.update(dataVO);
    if(count == 1) {
      System.out.println("수정 처리 성공");
    } else {
      System.out.println("수정 처리 실패");
    }
  }
  
  public void delete() {
    int datano = 0;
    
    System.out.print("데이터번호: ");
    datano = Integer.parseInt(in.nextLine());
    
    int count = this.dataDAO.delete(datano);
    if(count == 1) {
      System.out.println("삭제 성공");
    } else {
      System.out.println("삭제 실패");
    }
  }
}
