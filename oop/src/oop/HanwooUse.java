package oop;

public class HanwooUse {

  public static void main(String[] args) {
 
    Hanwoo hanwoo = new Hanwoo();
    
    hanwoo.product = "�ɵ��";
    hanwoo.origin = "Ⱦ��";
    hanwoo.weight = 200;
    hanwoo.price = ((hanwoo.weight/100) * 8000);
    hanwoo.salePrice = (int)(hanwoo.price - (hanwoo.price*0.1));
    
    System.out.println(hanwoo.product + "  ��ǰ��");
    System.out.println(hanwoo.origin + "  ������");
    System.out.println(hanwoo.weight + "g    ����");
    System.out.println(hanwoo.price + "��   ����");
    System.out.println(hanwoo.salePrice + "��    ���ΰ�");

  }

}
