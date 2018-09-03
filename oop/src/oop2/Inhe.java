package oop2;
 
public class Inhe {
 
  public static void main(String[] args) {
    Phone phone = new Phone();
    System.out.println(phone.phone_name);
    phone.tel();
    phone.sms();
    
    
    System.out.println("---------------------");
    
    PDA pda = new PDA();
    System.out.println(pda.pda_name);
    pda.tel();
    pda.sms();
    pda.mms();
    pda.camera();
    
    
    System.out.println("---------------------");
    
    Smart smart = new Smart();
    smart.tel();
    smart.sms();
    smart.mms();
    smart.camera();
    smart.market();
    smart.internet();
    
     
    System.out.println("---------------------");
    
    FIR fir = new FIR();
    fir.tel();
    fir.sms();
    fir.mms();
    fir.camera();
    fir.market();
    fir.internet();
    fir.iot();
    fir.bigdata();
    fir.ai();
  }
 
}
  