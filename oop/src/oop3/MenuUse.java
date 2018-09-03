package oop3;

public class MenuUse {

  public static void main(String[] args) {
    MenuList list = new MenuList();
    One one = list.getMenu1();
    System.out.println("MenuUse one: " + one.hashCode());
    System.out.println(one.menu);
    
    Two two = list.getMenu2();
    System.out.println(two.menu);
    
    Three three = list.getMenu3();
    System.out.println(three.menu);
    
    Four four = list.getMenu4();
    System.out.println(four.menu);
  }

}
