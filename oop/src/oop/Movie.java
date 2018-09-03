package oop;

public class Movie {

  public void print(String name) {
    System.out.println("영화명: " + name);
    System.out.println("---------------------");
    
  }
  
  public void print(String name , String genre) {
    System.out.println("영화명: " + name);
    System.out.println("장   르: " + genre);
    System.out.println("---------------------");
    
  }
  
  public void print(String name , String genre, 
      int time) {
    System.out.println("영화명: " + name);
    System.out.println("장   르: " + genre);
    System.out.println("시   간: " + time);
    System.out.println("---------------------");
    
  }

  public void print(String name , String genre, 
      int time, double averge, int year) {
    System.out.println("영화명: " + name);
    System.out.println("장   르: " + genre);
    System.out.println("시   간: " + time);
    System.out.println("평   점: " + averge);
    System.out.println("개   봉: " + year);
    System.out.println("---------------------");
    
  }
  
}
