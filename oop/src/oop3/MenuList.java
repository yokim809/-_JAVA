package oop3;
 
public class MenuList {
  public One getMenu1() {
    One one = new One();
    System.out.println("MenuList one: " + one.hashCode());
    one.menu = one.menu + ", ���α�";
    
    return one;
  }
  
  public Two getMenu2() {
    Two two = new Two();
    two.menu = two.menu + ", �δ����";
    
    return two;
  }
  
  public Three getMenu3() {
    Three three = new Three();
    three.menu = three.menu + ", ������ �꽺";
    
    return three;
  }
  
  public Four getMenu4() {
    Four four = new Four();
    four.menu = four.menu + ", �췰��";
    
    return four;
  }
}
 