package oop5;

public class AbsTest {

  public static void main(String[] args) {
    //Payment payment = new Payment(); //추상메소드가 있을때는 객체를 만들 수 없다.
//    Pay2015 pay2015 = new Pay2015(); //객체 생성
//    pay2015.cach();
//    pay2015.card();
//    pay2015.mobile();
//    System.out.println("---------------------------------");
//    
//    Pay2016 pay2016 = new Pay2016();
//    pay2016.cach();
//    pay2016.card();
//    pay2016.mobile();
//    System.out.println("---------------------------------");
//    
//    Pay2017 pay2017 = new Pay2017();
//    pay2017.cach();
//    pay2017.card();
//    pay2017.mobile();
    Payment payment = null;
    payment = new Pay2015();
    payment.cach();
    payment.card();
    payment.mobile();
    System.out.println("---------------------------------");
    
    payment = new Pay2016();
    payment.cach();
    payment.card();
    payment.mobile();
    System.out.println("---------------------------------");
    
    payment = new Pay2017();
    payment.cach();
    payment.card();
    payment.mobile();
    System.out.println("---------------------------------");
    
  }

}
