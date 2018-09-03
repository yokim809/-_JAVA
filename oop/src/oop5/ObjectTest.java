package oop5;
 
class Korea{ //기본적으로 Object를 상속하고 있다. F4버튼을 눌러 확인해볼 것!
  public void print() {
    System.out.println("한국");
  }
}
 
class Japan extends Object{ //extends Object를 하면 다른 클래스를 상속받을 수 없기때문에 가급적 안하는 것이 좋다.
  public void print() {
    System.out.println("일본");
  }
}
 
class China extends Object{
  public void print() {
    System.out.println("중국");
  }
}
 
public class ObjectTest {
 
  public static void main(String[] args) {
    //int year = 2017.5; 좌변 타입과 우변 타입은 같아야 한다. 즉 ERROR 발생.
    Object object1 = new Korea(); // Object와 Korea가 상속관계이기때문에 ERROR가 발생하지 않는다.
    Object object2 = new Japan(); // 상속 관계, 부모 <-- 자식, 왼쪽 타입 우선으로 인식
    Object object3 = new China(); // 상속 관계, 부모 <-- 자식
    
    System.out.println(object1 instanceof Object); //instanceof 타입에 포함되는지 확인
    System.out.println(object1 instanceof Korea); //타입에 포함되는지 확인
    
    //2가지 이상의 타입에 포함, 다형성
    
    //Korea korea = new Japan(); // ERROR 상속관계가 아닌 자식들과의 관계에서는 ERROR가 발생한다.
    
    //Korea korea2 = object1; // ERROR
    
    Korea korea = (Korea)object1; //객체 형변환
    
    //object1..print(); //호출 불가 (부모타입 우선)
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