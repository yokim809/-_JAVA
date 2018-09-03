package oop;

public class HanwooUse {

  public static void main(String[] args) {
 
    Hanwoo hanwoo = new Hanwoo();
    
    hanwoo.product = "꽃등심";
    hanwoo.origin = "횡성";
    hanwoo.weight = 200;
    hanwoo.price = ((hanwoo.weight/100) * 8000);
    hanwoo.salePrice = (int)(hanwoo.price - (hanwoo.price*0.1));
    
    System.out.println(hanwoo.product + "  상품명");
    System.out.println(hanwoo.origin + "  원산지");
    System.out.println(hanwoo.weight + "g    무게");
    System.out.println(hanwoo.price + "원   정가");
    System.out.println(hanwoo.salePrice + "원    할인가");

  }

}
