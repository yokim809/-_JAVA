package oop4;
 
class Final{
  // 1) ��ü �����ؾ� ��� ����, �� ���� ����, ���� ���� ���, instance ����
  private String normal = "���� ��ǳ ���� ����"; 
  
  // 2) ��ü ���� ���ص� ��� ����, �� ���� ����, ���� ���, ���� ����
  public static int COUNT = 0;   
  
  // 3) ��ü �����ؾ� ��� ����, ���� �� ���� �Ұ���, ��� ���� 
  public final String com = "(��)�ູ �����";
 
  // 4) ��ü ���� ���ص� ��� ����, ���� �� ���� �Ұ���, ��� ����, ���� ���� ����
  // public static final String TEL = "�� 02-1111-1111";  
  public final static String TEL = "�� 02-1111-1111";
  
  // private ������ �� ����
  public String getNormal(){
    return this.normal;
  }
  
  // private ������ �� ����
  public void setNormal(String normal) {
    this.normal = normal;
  }
}
 
public class FinalTest {
  public static void main(String[] args) {
    Final obj = new Final();
    // System.out.println("����: " + obj.normal); // ERROR
    System.out.println("����: " + obj.getNormal());
    
    obj.setNormal("���� Ʃ�︳ ����");
    System.out.println("����: " + obj.getNormal());
    
    Final.COUNT++;
    System.out.println("���� �ο�: " + Final.COUNT);
    
    //obj.com = "(��)����"; // The final field Final.com cannot be assigned final ������ �ѹ� �Ҵ��ϸ� ���� �Ұ����ϴ�.
    System.out.println("�����: " + obj.com);
    System.out.println("����ó: " + Final.TEL);
  }
 
}