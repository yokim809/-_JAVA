
public class DoWhile3 {

  public static void main(String[] args) {
    
    int count=0;      // ����
    int oddcount=0;  // Ȧ�� ����
    int evencount=0; // ¦�� ����
    
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
    
    System.out.println("Ȧ�� ����: " + oddcount);
    System.out.println("¦�� ����: " + evencount);
  }

}
