package oop;
 
public class MovieMain {
 
  public static void main(String[] args) {
    Movie movie = new Movie();
    movie.print("검은 사제들");
    movie.print("더 라이트", "퇴마");
    movie.print("엑소시스트", "퇴마",  120);
    movie.print("컨저링2", "퇴마", 131, 7.6, 2016);
  }
 
}