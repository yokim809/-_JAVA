
public class IfExam8 {

  public static void main(String[] args) {
    String cpu = args[0];
    int ram = Integer.parseInt(args[1]);
    String ssd = args[2];
    int cpuPrice = 0;
    int ramPrice = 0;
    int ssdPrice = 0;
    int totalPrice = 0;
    
    if(cpu.equals("i3") == true) {
      cpuPrice = 100000;
    } else if(cpu.equals("i5") == true) {
      cpuPrice = 150000;
    } else if(cpu.equals("i7") == true) {
      cpuPrice = 200000;
    }
    ramPrice = ram * 10000;
    if(ssd.equals("128SSD")) {
      ssdPrice = 100000;
    } else if(ssd.equals("256SSD")) {
      ssdPrice = 150000;
    }
    totalPrice = cpuPrice+ ramPrice+ssdPrice;
    
    System.out.println("CPU: " + cpu + " " + cpuPrice + " ��");
    System.out.println("RAM: "+ ram + "G " + ramPrice + " ��");
    System.out.println("SSD: "+ ssd + " " + ssdPrice + " ��");
    System.out.println("-------------------------------------");
    System.out.println("���� �ݾ�: " + totalPrice + " ��");
    

  }

}
