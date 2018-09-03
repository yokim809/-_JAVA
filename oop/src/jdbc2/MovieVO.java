package jdbc2;
 
public class MovieVO {
/*
  movieno INT                NOT NULL AUTO_INCREMENT, -- ��ȭ ��ȣ
  title       VARCHAR(100) NOT NULL, -- ��ȭ ����(����)
  good     FLOAT             NOT NULL, -- ����
  name    VARCHAR(30)    NOT NULL,-- �⿬
  rdate    DATETIME         NOT NULL, -- ��� ��¥
 */
 
  private int movieno;
  private String title;
  private double good;
  private String name;
  private String rdate;
  
  public int getMovieno() {
    return movieno;
  }
  public void setMovieno(int movieno) {
    this.movieno = movieno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public double getGood() {
    return good;
  }
  public void setGood(double good) {
    this.good = good;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
  @Override
  public String toString() {
    return "MovieVO [movieno=" + movieno + ", title=" + title + ", good=" + good + ", name=" + name + ", rdate=" + rdate
        + "]";
  }
  
  /*
  // setter
  public void setMovieno(int movieno) {
    this.movieno = movieno;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setGood(double good) {
    this.good = good;
  }
  
  public void setName(String name) {
    this.name = name;
  }
 
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
  // getter
  public int getMovieno() {
    return this.movieno;
  }
  
  public String getTitle() {
    return this.title;
  }
 
  public double getGood() {
    return this.good;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getRdate() {
    return this.rdate;
  }
  
  */
  
  
  
}
 
 
 