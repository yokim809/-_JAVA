package oop2;
 
public class UserException1 {
 
  public static void main(String[] args) {
    try {
      ExceptionUse max = new ExceptionUse();
      int year = Integer.parseInt(args[0]);
      max.use(year);

      
    } catch (PeriodException e) {
      System.out.println("PeriodException �߻���.");
    } catch (ZeroException e) {
      System.out.println("ZeroException �߻���.");
    } catch (Exception e) {
      System.out.println("Exception �߻���.");
    }
    
    System.out.println("Main �����.");
 
  }
 
}
 