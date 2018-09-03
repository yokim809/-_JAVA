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
   
   res = str.substring(0, 2);      // 0~2-1 : 0 ~ 1까지 나옴 -> Ho 가 출력 How 가 아니라
   System.out.println("4) " + res);
   
   res = str.substring(12, 16);   // JAVA 출력
   System.out.println("5) " + res);
      
   res = str.substring(12);
   System.out.println("6) " + res); // 12부터 마지막까지 출력
   
   res = "JAVA";
   if (res.equals("JAVA")) {
     System.out.println("7) " + "동일한 문자열입니다.");
   }
   
   if (res.equalsIgnoreCase("java")) {
     System.out.println("8)" + " 동일한 문자열입니다.");
   }
   
   if ("Winter.jpg".endsWith(".jpg")) {
     System.out.println("9)" + " 전송 가능");
   }
   
   int index = "ABC".indexOf("B");
   System.out.println("10) " + index);  // 1
   
   index = "ABC".indexOf("W");
   System.out.println("11) " + index); // -1 (없으면 -1)
   
   res = str.replace('A', 'B');    // 대응하는 모든 하나의 문자를 변경
   System.out.println("12) " + res);
   
   res = str.replace("JAVA", "JSP");    // 대응하는 모든 문자열을  변경
   System.out.println("13) " + res);
   
   
   
   
  }

}
