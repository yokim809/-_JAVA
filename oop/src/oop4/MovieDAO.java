package oop4;
 
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
 
public class MovieDAO {
  public Movie calc(String line) {
    System.out.println(line); // ȭ�� ���
    
    StringTokenizer st = new StringTokenizer(line, ",");
    String name = st.nextToken().trim(); // ��ȭ��
    String seat = st.nextToken().trim(); // �¼�
    int count = Integer.parseInt(st.nextToken().trim()); // ���μ�
    int child = Integer.parseInt(st.nextToken().trim()); // �л���
    
    int count_price = 0; // ���� �ݾ�
    int child_price = 0; // �л� �ݾ�
    int price = 0;  // �¼��� ����
    if (seat.equals("A")) {
      price = 11000;
    } else if (seat.equals("B")) {
      price = 11000;
    } else if (seat.equals("C")) {
      price = 11000;
    }
    count_price = count * price; // ���� �ݾ�
    child_price = child * (int)(price * 0.8); // �л� �ݾ�
    
    int total = count_price + child_price;
    int point = (int)(total * 0.05);
    
    Movie movie = new Movie(name, seat, count, child, count_price, child_price, price, total, point);
    return movie;
  }
  
  public void print(Movie movie, PrintWriter pw) { // Call By Reference
    DecimalFormat df = new DecimalFormat("#,###,### ��");
    
    pw.println("��ȭ��: " + movie.name);  // ���� ���
    pw.println("�¼�: " + movie.seat);
    pw.println("���μ�: " + movie.count + "��"); 
    pw.println("�л���: " + movie.child + "��");
    pw.println("���� �ݾ�: " + df.format(movie.count_price));
    pw.println("�л� �ݾ�: " + df.format(movie.child_price));
    pw.println("���� �ݾ�: " + df.format(movie.total));
    pw.println("����Ʈ(5%): " + df.format(movie.point));
    pw.println("-------------------------------");
 
  }
  
}
  