package oop4;
 
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
 
public class MovieDAO {
  public Movie calc(String line) {
    System.out.println(line); // 화면 출력
    
    StringTokenizer st = new StringTokenizer(line, ",");
    String name = st.nextToken().trim(); // 영화명
    String seat = st.nextToken().trim(); // 좌석
    int count = Integer.parseInt(st.nextToken().trim()); // 성인수
    int child = Integer.parseInt(st.nextToken().trim()); // 학생수
    
    int count_price = 0; // 성인 금액
    int child_price = 0; // 학생 금액
    int price = 0;  // 좌석당 가격
    if (seat.equals("A")) {
      price = 11000;
    } else if (seat.equals("B")) {
      price = 11000;
    } else if (seat.equals("C")) {
      price = 11000;
    }
    count_price = count * price; // 성인 금액
    child_price = child * (int)(price * 0.8); // 학생 금액
    
    int total = count_price + child_price;
    int point = (int)(total * 0.05);
    
    Movie movie = new Movie(name, seat, count, child, count_price, child_price, price, total, point);
    return movie;
  }
  
  public void print(Movie movie, PrintWriter pw) { // Call By Reference
    DecimalFormat df = new DecimalFormat("#,###,### 원");
    
    pw.println("영화명: " + movie.name);  // 파일 기록
    pw.println("좌석: " + movie.seat);
    pw.println("성인수: " + movie.count + "명"); 
    pw.println("학생수: " + movie.child + "명");
    pw.println("성인 금액: " + df.format(movie.count_price));
    pw.println("학생 금액: " + df.format(movie.child_price));
    pw.println("결재 금액: " + df.format(movie.total));
    pw.println("포인트(5%): " + df.format(movie.point));
    pw.println("-------------------------------");
 
  }
  
}
  