package oop;

public class Movie {

  public void print(String name) {
    System.out.println("��ȭ��: " + name);
    System.out.println("---------------------");
    
  }
  
  public void print(String name , String genre) {
    System.out.println("��ȭ��: " + name);
    System.out.println("��   ��: " + genre);
    System.out.println("---------------------");
    
  }
  
  public void print(String name , String genre, 
      int time) {
    System.out.println("��ȭ��: " + name);
    System.out.println("��   ��: " + genre);
    System.out.println("��   ��: " + time);
    System.out.println("---------------------");
    
  }

  public void print(String name , String genre, 
      int time, double averge, int year) {
    System.out.println("��ȭ��: " + name);
    System.out.println("��   ��: " + genre);
    System.out.println("��   ��: " + time);
    System.out.println("��   ��: " + averge);
    System.out.println("��   ��: " + year);
    System.out.println("---------------------");
    
  }
  
}
