package jdbc2;

public class PayVO {
/*  payno INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  basic INT NOT NULL,
  year INT NOT NULL,
  sudang INT NOT NULL,
  salary INT NOT NULL,
  rdate DATETIME NOT NULL, -- 등록 날짜*/
  private int payno;
  private String name;
  private int basic;
  private int year;
  private int sudang;
  private int salary;
  private String rdate;
  
  public int getPayno() {
    return payno;
  }
  public void setPayno(int payno) {
    this.payno = payno;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getBasic() {
    return basic;
  }
  public void setBasic(int basic) {
    this.basic = basic;
  }
  public int getYear() {
    return year;
  }
  public void setYear(int year) {
    this.year = year;
  }
  public int getSudang() {
    return sudang;
  }
  public void setSudang(int sudang) {
    this.sudang = sudang;
  }
  public int getSalary() {
    return salary;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
}
