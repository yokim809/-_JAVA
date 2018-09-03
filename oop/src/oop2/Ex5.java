package oop2;
 
public class Ex5 {
 
  public static void main(String[] args) {
    try {
      int year = Integer.parseInt(args[0]);
      int avg = 2017 / year;
      
      String str = null;
      System.out.println(str.toLowerCase());
      
    } catch (NumberFormatException e) {
      System.out.println("������ �Է��ϼ���. ��) 1 ~ ");
    } catch (ArithmeticException e) {
      System.out.println("0���� ���� �� �����ϴ�.");
    } catch (NullPointerException e) {
      System.out.println("��ü�� �������� �ʾҽ��ϴ�.");
    } catch (Exception e) {
      System.out.println("���ܰ� �߻��߽��ϴ�.");
    }
    
    System.out.println("������ ó�����Դϴ�...");
 
  }
 
}