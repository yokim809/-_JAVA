
public class IfExam10 {

  public static void main(String[] args) {
    String country = args[0];
    int person = Integer.parseInt(args[1]);
    int price = 0;
    int totalPrice = 0;
    
    if(country.equals("�Ϻ�") == true) {
      price = 500000;
    } else if(country.equals("�߱�") == true) {
      price = 300000;
    } else if(country.equals("�븸") == true) {
      price = 400000;
    }

    totalPrice = price*person;
    
    if(person >= 1 && person <= 30) {
     System.out.println("����: " + country);
     System.out.println("����: " + person + " �� " + totalPrice +  "��");
     System.out.println("----------------------------");
     System.out.println("���� �ݾ�: " + totalPrice + " ��");
    } else {
        System.out.println("������� 1~30������ ���� �� �� �ֽ��ϴ�.");
    }
      
    
  }

}
