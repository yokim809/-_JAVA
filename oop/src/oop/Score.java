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
    
    System.out.println("����: " + this.name);
    System.out.println("����: " + this.ele);
    System.out.println("����: " + this.mat);
    System.out.println("����: " + this.eng);
    System.out.println("����: " + tot);
    System.out.println("���: " + avg);
    
  }

}
