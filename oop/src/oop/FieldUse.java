package oop;
 
public class FieldUse {
 
   public static void main(String[] args) {
      // fieldTest: ��ü
      FieldTest fieldTest = new FieldTest();
      System.out.println(fieldTest.year); // 0
      System.out.println(fieldTest.product); // null
      System.out.println(fieldTest.price); // 0
      System.out.println(fieldTest.dc); // 0.0
      System.out.println(fieldTest.as); // false
      System.out.println(">" + fieldTest.grade + "<");
      System.out.println("-----------------");
      
      fieldTest.year = 2016;
      fieldTest.product = "��Ʈ��";
      fieldTest.price = 600000;
      fieldTest.dc = 3.5;
      fieldTest.as = true;
      fieldTest.grade = 'A';
      
      System.out.println(fieldTest.year); 
      System.out.println(fieldTest.product); 
      System.out.println(fieldTest.price);
      System.out.println(fieldTest.dc);
      System.out.println(fieldTest.as);
      System.out.println(fieldTest.grade);
      
   }
 
}
  