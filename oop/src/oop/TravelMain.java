package oop;
 
public class TravelMain {
 
  public static void main(String[] args) {
    Travel travel = new Travel();
    travel.trip1();
    travel.trip2();
    travel.trip3();
    travel.trip4();
    travel.trip5();
    travel.trip6();

    System.out.println("main() travel: " + travel.hashCode());
    travel.print(); // ��ü�����δ� ��������(�ʵ�)�� �޼ҵ常 ȣ�� �����ϸ�
                    // ���������� ȣ��(���� �Ұ���
      
    travel.print("û���");
 
  }
 
}