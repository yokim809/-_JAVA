
public class ifTest {

  public static void main(String[] args) {
    int age = 19;
    String vote = (age >= 19) ? "��ǥ����":"��ǥ �Ұ���"; // 3�� ������
    System.out.println(vote);
    
    int tot = 80;
    if(tot >= 80) {
      System.out.println("�հ�");
      System.out.println("��Ʈ��");
    }
    
    int su = 1;
    System.out.println("����:" + su);
    
    if(su%2 ==0) {
      System.out.println("¦��"); // true
    }  else {
      System.out.println("Ȧ��"); // false
    }
    String month ="";
      if(su == 1) {
        month = "January";
      } else if(su == 2) {
        month = "February";      
      } else if(su ==3) {
        month = "March";
      } else {
        month = "1~3�� �Է����ּ���.";
      }
 
      System.out.println(month);
  
      String korean = "'";
        if(month.equals("January")){  // month == "January" �� ���� �ƶ�
          korean = "1�� ����";
        } else if (month.equals("February")) { // month == "February" �� ���� �ƶ�
          korean = "2�� ����";
        } else if (month.equals("March")) {
          korean = "3�� ��";
        } else {
          korean = "�ش��ڷ� ����";
        }
        
        System.out.println(korean);
        
        int test = 85;
        if(test >= 60) {
          System.out.println("�հ��Դϴ�.");
          
          if(test >=80) {
            System.out.println("-> ������Ʈ ����");  //85~
          } else {
            System.out.println("-> �߰����� �ǽ�"); //60~84
          }
          
        } else {
          System.out.println("���հ��Դϴ�."); //~59
        }
        
        String grade ="";
        if(test >= 90) {
          grade = "A";
        } else if(test >= 80 && test <=89) { // && ->and
          grade = "B";
        } else if(test >= 70 && test <=79) { // && ->and
          grade = "C";
        } else if(test >= 60 && test <=69) { // && ->and
          grade = "D";
        } else {
          grade = "F";
        }
        
        System.out.println("grade:" + grade);
        
        int season = 7;
        if(season ==6 || season == 7 || season ==8) { // || ->or
          System.out.println("�����Դϴ�.");
        }
  
  }
}

