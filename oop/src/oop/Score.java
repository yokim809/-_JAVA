package oop;

public class Score {
  
    String name;
    int ele;
    int mat;
    int eng;
    
  
  public void setData(String name, int ele,int mat,int eng) {
    
    this.name = name;
    this.ele = ele;
    this.mat = mat;
    this.eng = eng;
    
  }
  public void print() {
    
    int tot = this.ele + this.mat + this.eng;
    int avg = tot/3;
    
    System.out.println("성명: " + this.name);
    System.out.println("전산: " + this.ele);
    System.out.println("수학: " + this.mat);
    System.out.println("영어: " + this.eng);
    System.out.println("총점: " + tot);
    System.out.println("평균: " + avg);
    
  }

}
