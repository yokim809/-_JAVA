package oop2;
 
public class UserException2 {
 
  public static void main(String[] args) {
    try {
      ExceptionUse max = new ExceptionUse();
      int year = Integer.parseInt(args[0]);
      max.use(year);

      
    } catch (PeriodException e) {
      System.out.println("PeriodException ¹ß»ýµÊ.");

    } catch (Exception e) {
      System.out.println("Exception ¹ß»ýµÊ.");
    }
    
    System.out.println("Main ½ÇÇàµÊ.");
 
  }
 
}
 