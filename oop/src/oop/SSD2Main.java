package oop;

public class SSD2Main {

  public static void main(String[] args) {
//    SSD2 ssd;
//    ssd.print();      //ERROR
    
//    SSD2 ssd = null;
//    ssd.print();  //java.lang.NullPointerException

    SSD2 ssd2 = new SSD2(); // ssd °´Ã¼ »ý¼º
    ssd2.print();
    
   ssd2.name = "256 GB";
   ssd2.price = 90000;
   ssd2.dc = ssd2.price - 5000;
   ssd2.point = (int)(ssd2.price * 0.03); // 3 %
   ssd2.count = 2;
    
   ssd2.print();
  }

}
