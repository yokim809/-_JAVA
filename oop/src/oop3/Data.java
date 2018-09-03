package oop3;

public class Data {
  int su1 = 0;
  int su2 = 0;
 
  public Data() { // 생략하면 ERROR 발생 인수생성자를 선언했기 때문에 반드시 선언 할 것
    
  }

public Data(int su1,int su2){
    this.su1 = su1;
    this.su2 = su2;
  }
}