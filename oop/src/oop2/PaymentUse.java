package oop2;
 
public class PaymentUse {
 
  public static void main(String[] args) {
    Cash cash = new Cash();
    cash.order("¥���", 5000,  2); // ��ӵ�
    cash.calc();                          // ��ӵ�
    cash.cash();
    System.out.println("-------------------------");
    Card card = new Card();
    card.order("���", 2000, 5);
    card.calc();
    card.card();
    System.out.println("-------------------------");
    Mobile mobile = new Mobile();
    mobile.order("��ȱ�", 5000, 2);
    mobile.calc();
    mobile.mobile();
    System.out.println("-------------------------");
    Point point = new Point();
    point.order("�Ƹ޸�ī��", 2000, 3);
    point.calc();
    point.point();
  }
 
}
 