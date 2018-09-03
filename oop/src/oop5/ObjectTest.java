package oop5;
 
class Korea{ //�⺻������ Object�� ����ϰ� �ִ�. F4��ư�� ���� Ȯ���غ� ��!
  public void print() {
    System.out.println("�ѱ�");
  }
}
 
class Japan extends Object{ //extends Object�� �ϸ� �ٸ� Ŭ������ ��ӹ��� �� ���⶧���� ������ ���ϴ� ���� ����.
  public void print() {
    System.out.println("�Ϻ�");
  }
}
 
class China extends Object{
  public void print() {
    System.out.println("�߱�");
  }
}
 
public class ObjectTest {
 
  public static void main(String[] args) {
    //int year = 2017.5; �º� Ÿ�԰� �캯 Ÿ���� ���ƾ� �Ѵ�. �� ERROR �߻�.
    Object object1 = new Korea(); // Object�� Korea�� ��Ӱ����̱⶧���� ERROR�� �߻����� �ʴ´�.
    Object object2 = new Japan(); // ��� ����, �θ� <-- �ڽ�, ���� Ÿ�� �켱���� �ν�
    Object object3 = new China(); // ��� ����, �θ� <-- �ڽ�
    
    System.out.println(object1 instanceof Object); //instanceof Ÿ�Կ� ���ԵǴ��� Ȯ��
    System.out.println(object1 instanceof Korea); //Ÿ�Կ� ���ԵǴ��� Ȯ��
    
    //2���� �̻��� Ÿ�Կ� ����, ������
    
    //Korea korea = new Japan(); // ERROR ��Ӱ��谡 �ƴ� �ڽĵ���� ���迡���� ERROR�� �߻��Ѵ�.
    
    //Korea korea2 = object1; // ERROR
    
    Korea korea = (Korea)object1; //��ü ����ȯ
    
    //object1..print(); //ȣ�� �Ұ� (�θ�Ÿ�� �켱)
    korea.print();
    System.out.println("---------------------------------------");
    
    System.out.println(object2 instanceof Object);
    System.out.println(object2 instanceof Japan);
    
    Japan japan = (Japan)object2;
    japan.print();
    System.out.println("---------------------------------------");
    
    System.out.println(object3 instanceof Object);
    System.out.println(object3 instanceof China);
    
    China china = (China)object3;
    china.print();
  }
    
 
  }