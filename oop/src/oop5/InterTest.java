package oop5;

public class InterTest {

  public static void main(String[] args) {
    //Smartphone smartphone = new Smartphone();
    Smartphone smartphone = new Android();
    smartphone.map();
    smartphone.nfc();
    
    System.out.println("---------------------------");
    smartphone = new IPhone();
    smartphone.map();
    smartphone.nfc();
  }
}
