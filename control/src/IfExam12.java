
public class IfExam12 {

  public static void main(String[] args) {
    String pension ="";
    String barbecue = "";
    String seaSight = "";
    String tube = "";
    int pensionPrice = 0;   //��ǰ���
    int barbecuePrice = 0;  //�ٺ�ť ����
    int seaSightPrice = 0;    //�ٴ尡 ���� ����
    int tubePrice = 0;        //������ Ʃ�� ����
    int totalPrice = 0;       //����ݾ�
    pension = args[0];       
    barbecue = args[1];
    seaSight = args[2];
    tube = args[3];
    
    if(pension.equals("���1") == true) {
      pensionPrice = 80000;
    } else if(pension.equals("���2") == true) {
      pensionPrice = 120000;
    } else if(pension.equals("���3") == true) {
      pensionPrice = 150000;
    }
    
    if(barbecue.equals("Y") == true || barbecue.equals("y") == true) {
      barbecuePrice = 30000;
    } 
    if(seaSight.equals("Y") == true || seaSight.equals("y") == true ) {
      seaSightPrice = 20000;
    }
    if(tube.equals("Y") == true || tube.equals("y") == true ) {
      tubePrice = 10000;
    }
 
    totalPrice = pensionPrice + barbecuePrice + seaSightPrice + tubePrice;
    
    System.out.println("���: " + pension);
    System.out.println("����: " + pensionPrice + "��");  
    System.out.println("�ٺ�ť: " + barbecuePrice + "��");  
    System.out.println("�ٴ尡����: " + seaSightPrice + "��"); 
    System.out.println("������Ʃ��: " + tubePrice + "��");
    System.out.println("-----------------------------------");
    System.out.println("���� �ݾ�: " + totalPrice + " ��");
    

  }

}
