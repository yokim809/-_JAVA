
public class IfExam5 {

  public static void main(String[] args) {
    int year = Integer.parseInt(args[0]);
    String grade = "";
    String pay = "";
    
    if (year >=0 && year <=5) {
      grade = "�ʱ�" ;
      pay = "2300 ~ 4500";
    } else if (year >=6 && year <=8) {
      grade = "�߱�";
      pay = "4500 ~ 5500";
    } else if (year >=9 && year <=11) {
      grade = "���";
      pay = "5500 ~ 6500";
    } else if (year >= 12) {
      grade = "Ư��";
      pay = "6500 ~ 7500";
    }
    
    System.out.println("���: " + year +" ��");
    System.out.println("���: " + grade +" �����");
    System.out.println("����: " + pay);
    
    
    
    
    
    
    

  }


}
