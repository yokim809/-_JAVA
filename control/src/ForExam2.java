
public class ForExam2 {

  public static void main(String[] args) {
    int oddsum = 0;
    int evensum = 0;
    for(int index =1 ; index<=100; index++) {
      if(index % 2 == 0) {
        evensum = evensum + index;
      } else if (index % 2 ==1) {
        oddsum = oddsum + index;
      }
      System.out.println(index);
    }
    System.out.println("Â¦¼öÀÇ ÇÕ: " + evensum);
    System.out.println("È¦¼öÀÇ ÇÕ: " + oddsum);

  }

}
