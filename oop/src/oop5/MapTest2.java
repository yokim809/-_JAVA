package oop5;
 
import java.util.HashMap;
 
public class MapTest2 {
 
  public static void main(String[] args) {
    Product pro1 = new Product("노트북", 500000, "아수스");
    Product pro2 = new Product("태블릿", 600000, "LG");
    Product pro3 = new Product("Desktop", 400000, "Dell");
    
    HashMap map = new HashMap();
    map.put("pro1", pro1);
    map.put("pro2", pro2);
    map.put("pro3", pro3);
    map.put("pro4", "korea"); // ERROR 발생 안됨.
    map.put("pro5", 2017);
    
    Product product  = (Product)map.get("pro1");
    product.print();
    product  = (Product)map.get("pro2");
    product.print();
    product  = (Product)map.get("pro3");
    product.print();
 
    System.out.println("------------------------");
 
    HashMap<String, Product> list = new HashMap<String, Product>();
    list.put("pro1", pro1);
    list.put("pro2", pro2);
    list.put("pro3", pro3);
    //list.put("pro4", "korea"); 지정된 타입만 사용해야 한다.
    //list.put("pro5", 2017);
    
    product = list.get("pro1");
    product.print();
    product = list.get("pro2");
    product.print();
    product = list.get("pro3");
    product.print();
 
  }
 
}
 