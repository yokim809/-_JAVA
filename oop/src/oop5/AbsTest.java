package oop5;

public class AbsTest {

  public static void main(String[] args) {
    //Payment payment = new Payment(); //�߻�޼ҵ尡 �������� ��ü�� ���� �� ����.
//    Pay2015 pay2015 = new Pay2015(); //��ü ����
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
