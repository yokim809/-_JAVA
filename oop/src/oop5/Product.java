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
    System.out.println("��ǰ��: " + name);
    System.out.println("����: " + price);
    System.out.println("��ǥ: " + brand);
    System.out.println();
  }
}