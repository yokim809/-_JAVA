
public class DoWhile4 {

  public static void main(String[] args) {
    
    int count=0;      // ¼ýÀÚ
    int oddsum=0;  // È¦¼ö ÇÕ
    int evensum=0; // Â¦¼ö ÇÕ
    
    do {
      count = count + 1;
          if(count % 2 == 0) {
            evensum = evensum + count;
          } else if(count  % 2 == 1) {
            oddsum = oddsum + count;
          }
          if(count == 100) {
            break;
          }
    } while(true);
    
    System.out.println("È¦¼ö °¹¼ö: " + oddsum);
    System.out.println("Â¦¼ö °¹¼ö: " + evensum);
  }

}
