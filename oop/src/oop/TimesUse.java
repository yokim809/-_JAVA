package oop;

public class TimesUse {

  public static void main(String[] args) {

    Times times = new Times();
    
    int counting = times.count(2016);
    
    System.out.println("1부터 2016까지 2,3,4의 배수 갯수: "+counting);
    
  }

}
