package oop2;
 
class ASIA{
  public ASIA(){
    super();
    System.out.println("1) ASIA created.");
  }
}
 
class KOREA extends ASIA{
  public KOREA(){
    super();
    System.out.println("2) KOREA created.");
  }  
}
 
class Seoul extends KOREA{
  public Seoul(){
    super();
    System.out.println("3) Seoul created.");
  }    
}
 
class Jongro extends Seoul {
  public Jongro(){
    super();
    System.out.println("4) ���� ������.");
  }
}
 
class Street1 extends Jongro {
  public Street1() {
    // super(); // ���� ����
    System.out.println("5) 1�� ������.");
  }
}
 
public class InheTest2 {
  public static void main(String[] args) {
    Street1 street1 = new Street1();
 
  }
 
}