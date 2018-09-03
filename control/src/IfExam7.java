
public class IfExam7 {

  public static void main(String[] args) {
    String cpu = args[0];
    int ram = Integer.parseInt(args[1]);
    int cpuPrice = 0;
    int ramPrice = 0;
    int totalPrice = 0;
    
    if(cpu.equals("i3") == true) {
      cpuPrice = 100000;
    } else if(cpu.equals("i5") == true) {
      cpuPrice = 150000;
    } else if(cpu.equals("i7") == true) {
      cpuPrice = 200000;
    }
    ramPrice = ram * 10000;
    totalPrice = cpuPrice+ ramPrice;
    
    System.out.println("CPU: " + cpu + " " + cpuPrice + " 원");
    System.out.println("RAM: "+ ram + "G " + ramPrice + " 원");
    System.out.println("-------------------------------------");
    System.out.println("결재 금액: " + totalPrice + " 원");
    

  }

}
