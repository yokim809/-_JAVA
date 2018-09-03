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
    int menu = 0; // ���� ����

    while(true) {
      System.out.println();
      System.out.println("Movie chart(ver 2.0)");
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
    //public void  create(String title, double good, String name){
    String title = "";
    double good = 0.0;
    String name = "";

    System.out.print("����: ");
    title = in.nextLine();

    System.out.print("��õ(0.0 ~ 10.0): ");
    good = Double.parseDouble(in.nextLine());

    System.out.print("�ֿ�: ");
    name = in.nextLine();

    MovieVO movieVO = new MovieVO();
    movieVO.setTitle(title);
    movieVO.setGood(good);
    movieVO.setName(name);

    int count = this.movieDAO.create(movieVO);
    
    if(count == 1) {
      System.out.println("��� ó�� ����");
    } else {
      System.out.println("��� ó�� ����");
    }
  }

  public void list() {
    ArrayList<MovieVO> list =  this.movieDAO.list(); //list�� ����Ÿ�� ArrayList<MovieVO>�� Ÿ������ ����ؾ��Ѵ�.
    int count = list.size();

    for(int i = 0; i < count; i++) {
      MovieVO movieVO = list.get(i);

      System.out.print(movieVO.getMovieno()+ ". " );
      System.out.print(movieVO.getTitle() + ": ");
      System.out.print(movieVO.getName());
      System.out.print("(" + movieVO.getGood() +") ");
      System.out.print(movieVO.getRdate().substring(0, 10));
      System.out.println();
      System.out.println("����������������������������������������������������");
    }
  }

  public void read() {
    System.out.print("��ȸ�� ��ȣ: ");
    int movieno = Integer.parseInt(in.nextLine());

    MovieVO movieVO = this.movieDAO.read(movieno);

    if(movieVO != null) {
      System.out.print(movieVO.getMovieno()+ ". " );
      System.out.print(movieVO.getTitle() + ": ");
      System.out.print(movieVO.getName());
      System.out.print("(" + movieVO.getGood() +") ");
      System.out.print(movieVO.getRdate().substring(0, 10));
      System.out.println();
      System.out.println("����������������������������������������������������");
    } else {
      System.out.println("��ȸ�Ͻ� ��ȣ�� ��ϵ� ��ȭ�� �����ϴ�.");
    }
  }

  public void update() {
    //public void  update(int movieno, String title, double good, String name)
    MovieVO movieVO = new MovieVO();
    int movieno = 0;
    String title = "";
    double good = 0.0;
    String name = "";

    System.out.print("��ȭ��ȣ: ");
    movieno = Integer.parseInt(in.nextLine());

    System.out.print("����: ");
    title = in.nextLine();

    System.out.print("��õ(0.0 ~ 10.0): ");
    good = Double.parseDouble(in.nextLine());

    System.out.print("�ֿ�: ");
    name = in.nextLine();

    movieVO.setMovieno(movieno);
    movieVO.setTitle(title);
    movieVO.setGood(good);
    movieVO.setName(name);

    int count = this.movieDAO.update(movieVO);
    if(count == 1) {
      System.out.println("���� ó�� ����");
    } else {
      System.out.println("���� ó�� ����");
    }

  }

  public void delete() {
    int movieno = 0;

    System.out.print("������ ��ȭ��ȣ: ");
    movieno = Integer.parseInt(in.nextLine());

    int count = this.movieDAO.delete(movieno);
    if(count == 1) {
      System.out.println("���� ó�� ����");
    } else {
      System.out.println("���� ó�� ����");
    }
    
  }


}