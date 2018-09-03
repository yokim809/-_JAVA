package oop;

public class Mean {
  
  public void avg(int mat,int eng) {
    int tot = (mat+eng)/2;
    System.out.println(tot);
  }

  public void avg(int mat,int eng,int sci) {
    int tot = (mat+eng+sci)/3;
    System.out.println(tot);
  }

  public void avg(int mat,int eng,double sci) {
    int tot = (int)((mat+eng+sci)/3.0);
    System.out.println(tot);
  }

  public void avg(double mat,double eng,double sci) {
    int tot = (int)((mat+eng+sci)/3.0);
    System.out.println(tot);
  }
  
  public void avg(String name, int mat , int eng,int sci) {
    int tot = ((mat+eng+sci)/3);
    System.out.println(name + ":" + tot);
  }
  
  public void avg(int a[]) { //avg(�迭�� �ҷ����̴� ����)
    
    int tot = 0;
    int avg = 0;
    
    for(int i = 0; i<a.length;i++) {
      tot = tot+a[i];
    }
    
    avg = tot/a.length;
    
    System.out.println("����� ����: " + a.length + "/��� :" +avg);
    
  }


}
