package jdbc2;

public class MapleVO {
/*  mapleno INT NOT NULL AUTO_INCREMENT,
  mountain VARCHAR(10) NOT NULL,
  mapledate DATE NOT NULL,
  price INT NOT NULL,
  count INT NOT NULL,
  total INT NOT NULL,
  rdate DATETIME NOT NULL,*/
  private int mapleno;
  private String mountain;
  private String mapledate;
  private int price;
  private int count;
  private int total;
  private String rdate;
  
  public int getMapleno() {
    return mapleno;
  }
  public void setMapleno(int mapleno) {
    this.mapleno = mapleno;
  }
  public String getMountain() {
    return mountain;
  }
  public void setMountain(String mountain) {
    this.mountain = mountain;
  }
  public String getMapledate() {
    return mapledate;
  }
  public void setMapledate(String mapledate) {
    this.mapledate = mapledate;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
}
