
public class DoWhile4 {

  public static void main(String[] args) {
    
    int count=0;      // ����
    int oddsum=0;  // Ȧ�� ��
    int evensum=0; // ¦�� ��
    
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
    
    System.out.println("Ȧ�� ����: " + oddsum);
    System.out.println("¦�� ����: " + evensum);
  }

}
