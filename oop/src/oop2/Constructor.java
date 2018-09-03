package oop2;
 
public class Constructor{
  String brand; //(기본값)null
  String cpu; 
  int ram;  //(기본값)0
  int hdd;
  boolean odd; //(기본값) false
  String graphic;
  int usb20;
  int usb30;
  boolean wifi;
  String comcase;
  
  public Constructor() {
    
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
  }

  public Constructor(String brand, String cpu, int ram, int hdd, boolean odd, String graphic, int usb20, int usb30,
      boolean wifi, String comcase) {
    this.brand = brand;
    this.cpu = cpu;
    this.ram = ram;
    this.hdd = hdd;
    this.odd = odd;
    this.graphic = graphic;
    this.usb20 = usb20;
    this.usb30 = usb30;
    this.wifi = wifi;
    this.comcase = comcase;
  }
  
  
 
}