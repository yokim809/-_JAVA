
public class DoWhile3 {

  public static void main(String[] args) {
    
    int count=0;      // 璋濠
    int oddcount=0;  // �汝� 偎熱
    int evencount=0; // 礎熱 偎熱
    
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
    
    System.out.println("�汝� 偎熱: " + oddcount);
    System.out.println("礎熱 偎熱: " + evencount);
  }

}
