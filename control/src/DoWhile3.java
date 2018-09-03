
public class DoWhile3 {

  public static void main(String[] args) {
    
    int count=0;      // ¼ýÀÚ
    int oddcount=0;  // È¦¼ö °¹¼ö
    int evencount=0; // Â¦¼ö °¹¼ö
    
    do {
      count = count + 1;
          if(count % 2 == 0) {
            evencount = evencount + 1;
          } else if(count  % 2 == 1) {
            oddcount = oddcount + 1;
          }
          if(count == 100) {
            break;
          }
    } while(true);
    
    System.out.println("È¦¼ö °¹¼ö: " + oddcount);
    System.out.println("Â¦¼ö °¹¼ö: " + evencount);
  }

}
