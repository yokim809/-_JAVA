
public class IfExam15 {

  public static void main(String[] args) {
    String bookName = "";
    int bookPrice = 0;        //å�ǰ���
    int bookAmout = 0;      //å�Ǽ���
    int bookTotalPrice = 0;   //å�� ������ ���� ��
    int point = 0;              // ����Ʈ
    int totalPrice = 0;         //����ݾ�
    int delivery = 0;           //��ۺ�
    
    bookName = args[0];
    bookPrice = Integer.parseInt(args[1]);
    bookAmout = Integer.parseInt(args[2]);
    
    bookTotalPrice = bookAmout*bookPrice;
    
    if(bookTotalPrice < 20000) {
      delivery = 2500; 
    }
    
    totalPrice = bookTotalPrice + delivery;
    point = (int)(bookTotalPrice * 0.05);
    
    System.out.println("������: " + bookName + " | " + "����: " + bookPrice + " ��" + " | " + "����: "+ bookAmout + "��");
    System.out.println("��ۺ�: " + delivery);
    System.out.println("-----------------------------------------------");
    System.out.println("���� ����: " + bookTotalPrice  +" (����Ʈ: " + point + " ��) " + "<- 5 % ���" );
    System.out.println("���� �ݾ�: " + totalPrice);
    
    
      
    
    
    
    
    
    
    
    

  }

}
