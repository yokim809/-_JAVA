public class Array1 {
 
  public static void main(String[] args) {
    String[] months = {"January", "February", "March", "April", "May", "June", "Juliy", "August", "Setember", "October", "November", "December"};
 
    int array = Integer.parseInt(args[0]);
    
    System.out.println(months[array-1]);

 
  }
 
}
 