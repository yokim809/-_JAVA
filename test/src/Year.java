
public class Year {

  public static void main(String[] args) {
  
    System.out.println(2/3);
    System.out.println(2/3.0);
    System.out.println(2 % 3);
    System.out.println(3 % 3);
    
    int year = 2010;
    System.out.println(year);
    
    year = year + 1;
    System.out.println(year);
    
    year = year + 1;
    System.out.println(year);
    
    year +=1;
    System.out.println(year);
    
    year++;
    System.out.println(year);
    
    --year;
    System.out.println(year);
    
    
    
    int sum = 0;
    int su1 = 0;
    int su2 = 0;
//    sum = ++su1 + su2++; 은? , 비권장
    
    
    su1 = su1 + 1;
    sum  = su1 + su2;
    su2 = su2+1;
    
    System.out.println("su1:" + su1);
    System.out.println("su2:" + su2);
    System.out.println("sum:" + sum);
  }

}
