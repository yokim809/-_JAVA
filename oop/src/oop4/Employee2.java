package oop4;
 
public class Employee2 {
  private String name;
  private int java;
  private int web;
  private int dbms;
  private int tot;
  private double avg;
 
  public Employee2() {
    
  }
 
  public Employee2(String name, int java, int web, int dbms) {
    this.name = name;
    this.java = java;
    this.web = web;
    this.dbms = dbms;
  }
  
  public void calc() {
    this.tot = this.java + this.web + this.dbms;
    this.avg = (this.tot / 3.0) + 0.5;
  }
  
  public void print() {
    System.out.println("����: " + this.name);
    System.out.println("JAVA: " + this.java);
    System.out.println("WEB: " + this.web);
    System.out.println("DBMS: " + this.dbms);
    System.out.println("����: " + this.tot);
    System.out.println("���: " + (int)this.avg);
    System.out.println("����������������");
  }
}
  