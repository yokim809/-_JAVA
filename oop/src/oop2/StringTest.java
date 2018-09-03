package oop2;

public class StringTest {

  public static void main(String[] args) {
   String str = "How was the JAVA class?";
   String res = str.toLowerCase();   
   System.out.println("1) " + res);
   
   res = str.toUpperCase();
   System.out.println("2) " + res);
   
   int count = str.length();
   System.out.println("3) " + count);
   
   res = str.substring(0, 2);      // 0~2-1 : 0 ~ 1���� ���� -> Ho �� ��� How �� �ƴ϶�
   System.out.println("4) " + res);
   
   res = str.substring(12, 16);   // JAVA ���
   System.out.println("5) " + res);
      
   res = str.substring(12);
   System.out.println("6) " + res); // 12���� ���������� ���
   
   res = "JAVA";
   if (res.equals("JAVA")) {
     System.out.println("7) " + "������ ���ڿ��Դϴ�.");
   }
   
   if (res.equalsIgnoreCase("java")) {
     System.out.println("8)" + " ������ ���ڿ��Դϴ�.");
   }
   
   if ("Winter.jpg".endsWith(".jpg")) {
     System.out.println("9)" + " ���� ����");
   }
   
   int index = "ABC".indexOf("B");
   System.out.println("10) " + index);  // 1
   
   index = "ABC".indexOf("W");
   System.out.println("11) " + index); // -1 (������ -1)
   
   res = str.replace('A', 'B');    // �����ϴ� ��� �ϳ��� ���ڸ� ����
   System.out.println("12) " + res);
   
   res = str.replace("JAVA", "JSP");    // �����ϴ� ��� ���ڿ���  ����
   System.out.println("13) " + res);
   
   
   
   
  }

}
