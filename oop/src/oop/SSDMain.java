package oop;

public class SSDMain {

  public static void main(String[] args) {
    SSD ssd = new SSD(); // ssd ��ü ����
    System.out.println(ssd.hashCode()); //.���������
    //2018699554
    System.out.println(ssd.name);
    System.out.println(ssd.price +  " ��");
    System.out.println(ssd.dc + " ��");
    System.out.println(ssd.cnt + " ��");
    System.out.println("-----------------------");
    ssd.name = "256 GB";
    ssd.price = 70000;
    ssd.dc = ssd.price - 5000;
    ssd.cnt = 2;
    
    System.out.println(ssd.name);
    System.out.println(ssd.price +  " ��");
    System.out.println(ssd.dc + " ��");
    System.out.println(ssd.cnt + " ��");

  }

}
