
public class IfExam11 {

  public static void main(String[] args) {
    String country = args[0];
    int adult = Integer.parseInt(args[1]);
    int child = Integer.parseInt(args[2]);
    int adultprice = 0;
    int childprice = 0;
    int totalPrice = 0;
    
    if(country.equals("�Ϻ�") == true) {
      adultprice = 600000;
      childprice = 500000;
    } else if(country.equals("�߱�") == true) {
      adultprice = 400000;
      childprice = 300000;
    } else if(country.equals("�븸") == true) {
      adultprice = 500000;
      childprice = 400000;
    }

    totalPrice = (adult*adultprice)+(child*childprice) ;
    
   
     System.out.println("����: " + country);
     System.out.println("����: " + adult + " �� " + (adult*adultprice) +  "��");
     System.out.println("����: " + child + " �� " + (child*childprice) +  "��");
     System.out.println("----------------------------");
     System.out.println("���� �ݾ�: " + totalPrice + " ��");
    

      
    
  }

}
