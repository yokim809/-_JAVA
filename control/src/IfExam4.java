
public class IfExam4 {

  public static void main(String[] args) {
    int month = Integer.parseInt(args[0]);
    String trip = "";
    
    if(month>=3 && month <=5) {
      trip = "�뿵";
    } else if(month>=6 && month <=8) {
      trip = "�̽÷� ���� ����̺�";
    } else if(month>=9 && month <=11) {
        if(month == 9){
          trip = "���ǻ�";
        } else if(month == 10){
          trip = "������";
        } else if(month == 11){
          trip = "����� ��ǳ";
        }
    } else if(month==12 || month >=1 && month <=2) {
      trip = "�Ѱ�� �� ����̺�";
    } 
    
   System.out.println("��: " + month);
   System.out.println(trip);  
    
    
    
    

  }

}
