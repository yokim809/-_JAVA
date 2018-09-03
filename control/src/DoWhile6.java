
public class DoWhile6 {

  public static void main(String[] args) {
    double tot = 0.0; // 8byte
    int child = 0;
    double parent = 0.0;

    do {
      child = child +1;
      parent = child* 2.0;
      tot = tot + (child/parent);
      
      if(child == 10) {
        break;
      }
        
    }while(true);
    System.out.println("гую╨: " + tot);
    
  }

}
