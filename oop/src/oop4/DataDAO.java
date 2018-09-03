package oop4;
 
import java.io.PrintWriter;
 
public class DataDAO {
  public Data calc(String line) {
    System.out.println(line); // 화면 출력
    
    String[] values = line.split(",");
    String name = values[0];
    int java = Integer.parseInt(values[1]);
    int html = Integer.parseInt(values[2]);
    int css3 = Integer.parseInt(values[3]);
    
    int tot = java + html + css3;
    int avg = tot / 3;
    
    Data data = new Data(name, java,html, css3,tot,avg);
    return data;
  }
  
  public void print(Data data, PrintWriter pw) {
    pw.print(data.name);  // 파일 기록
    pw.print("\t\t"+ data.java);
    pw.print("\t\t"+ data.html);
    pw.print("\t\t"+ data.css3);
    pw.print("\t\t"+ data.tot);
    pw.print("\t\t"+ data.avg);
    pw.print("\n");
  }
  
}