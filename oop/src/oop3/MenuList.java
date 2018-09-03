package oop3;
 
public class MenuList {
  public One getMenu1() {
    One one = new One();
    System.out.println("MenuList one: " + one.hashCode());
    one.menu = one.menu + ", 만두국";
    
    return one;
  }
  
  public Two getMenu2() {
    Two two = new Two();
    two.menu = two.menu + ", 부대찌게";
    
    return two;
  }
  
  public Three getMenu3() {
    Three three = new Three();
    three.menu = three.menu + ", 생과일 쥬스";
    
    return three;
  }
  
  public Four getMenu4() {
    Four four = new Four();
    four.menu = four.menu + ", 우럭탕";
    
    return four;
  }
}
 