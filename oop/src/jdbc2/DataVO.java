package jdbc2;

public class DataVO {
/*  datano INT NOT NULL AUTO_INCREMENT, -- 번호
  name VARCHAR(10) NOT NULL, -- 성명 
  java INT NOT NULL, -- java
  html INT NOT NULL, -- html
  css3 INT NOT NULL, -- css3
  tot INT NOT NULL, -- tot3
  avg INT NOT NULL, -- avg*/
  private int datano;
  private String name;
  private int java;
  private int html;
  private int css3;
  private int tot;
  private int avg;
  
  public int getDatano() {
    return datano;
  }
  public void setDatano(int datano) {
    this.datano = datano;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getJava() {
    return java;
  }
  public void setJava(int java) {
    this.java = java;
  }
  public int getHtml() {
    return html;
  }
  public void setHtml(int html) {
    this.html = html;
  }
  public int getCss3() {
    return css3;
  }
  public void setCss3(int css3) {
    this.css3 = css3;
  }
  public int getTot() {
    return tot;
  }
  public void setTot(int tot) {
    this.tot = tot;
  }
  public int getAvg() {
    return avg;
  }
  public void setAvg(int avg) {
    this.avg = avg;
  }
}
