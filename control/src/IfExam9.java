public class IfExam9 {
 
  public static void main(String[] args) {
    String cpu = args[0];
    int cpuPrice = 0;  // int cpu_price = 0;
    int ram = Integer.parseInt(args[1]);
    int ramPrice = 0;
    String ssd = args[2]; // 128SSD
    int ssdPrice = 0;
    int etc = 370000; // ��Ÿ �ݾ�
    int dc = 0;          // ���� ����
    
    int totalPrice = 0; // ���� �ݾ�
    
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
      dc = (int)(totalPrice - (totalPrice * 0.05)); // ����ȯ
    }
    /*
    CPU: i7 200000 ��
    ------------------------
    ���� �ݾ�: 200000 ��
    */
    System.out.println("CPU: " + cpu + " " + cpuPrice + " ��");
    System.out.println("RAM: " + ram + " " + ramPrice + " ��");
    System.out.println("SSD: " + ssd + " " + ssdPrice + " ��");
    System.out.println("��Ÿ���: " + etc + " ��");
    System.out.println("--------------------------------");
    System.out.println("���� �ݾ�: " + totalPrice + " ��");    
    
    if (totalPrice >= 700000) {
      System.out.println("���� ����: " + dc + " ��");
    }
  }
 
}