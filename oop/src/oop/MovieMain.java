package oop;
 
public class MovieMain {
 
  public static void main(String[] args) {
    Movie movie = new Movie();
    movie.print("���� ������");
    movie.print("�� ����Ʈ", "��");
    movie.print("���ҽý�Ʈ", "��",  120);
    movie.print("������2", "��", 131, 7.6, 2016);
  }
 
}