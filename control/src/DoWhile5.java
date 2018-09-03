
public class DoWhile5 {

  public static void main(String[] args) {
    double tot = 0.0; // 8byte
    int child = 1;
    double parent = 0.0;

    do {
      parent = parent + 1.0;
      tot = tot + (child/parent);
      
      if(parent == 10.0) {
        break;
      }
        
    }while(true);
    System.out.println("гую╨: " + tot);
    
  }

}
