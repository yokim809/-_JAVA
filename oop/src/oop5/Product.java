package oop5;
 
class Product{
  private String name;
  private int price;
  private String brand;
  
  public Product() { }
 
  public Product(String name, int price, String brand) {
    this.name = name;
    this.price = price;
    this.brand = brand;
  }
 
  public void print(){
    System.out.println("상품명: " + name);
    System.out.println("가격: " + price);
    System.out.println("상표: " + brand);
    System.out.println();
  }
}