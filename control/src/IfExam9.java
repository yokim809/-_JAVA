public class IfExam9 {
 
  public static void main(String[] args) {
    String cpu = args[0];
    int cpuPrice = 0;  // int cpu_price = 0;
    int ram = Integer.parseInt(args[1]);
    int ramPrice = 0;
    String ssd = args[2]; // 128SSD
    int ssdPrice = 0;
    int etc = 370000; // 기타 금액
    int dc = 0;          // 할인 가격
    
    int totalPrice = 0; // 결재 금액
    
    if (cpu.equals("i3") == true) {
      cpuPrice = 100000;
    } else if (cpu.equals("i5") == true) {
      cpuPrice = 150000;
    } else if (cpu.equals("i7") == true) {
      cpuPrice = 200000;
    } 
    
    ramPrice = ram * 10000;
    
    if (ssd.equals("128SSD") || ssd.equals("128ssd")) {
      ssdPrice = 100000;
    } else if (ssd.equals("256SSD") || ssd.equals("256ssd")) {
      ssdPrice = 150000;
    } 
    
    totalPrice = cpuPrice + ramPrice + ssdPrice + etc;
    if (totalPrice >= 700000) {
      dc = (int)(totalPrice - (totalPrice * 0.05)); // 형변환
    }
    /*
    CPU: i7 200000 원
    ------------------------
    결재 금액: 200000 원
    */
    System.out.println("CPU: " + cpu + " " + cpuPrice + " 원");
    System.out.println("RAM: " + ram + " " + ramPrice + " 원");
    System.out.println("SSD: " + ssd + " " + ssdPrice + " 원");
    System.out.println("기타비용: " + etc + " 원");
    System.out.println("--------------------------------");
    System.out.println("결재 금액: " + totalPrice + " 원");    
    
    if (totalPrice >= 700000) {
      System.out.println("할인 가격: " + dc + " 원");
    }
  }
 
}