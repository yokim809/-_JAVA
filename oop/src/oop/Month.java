package oop;

public class Month {

  public String translation(int month) {
    
    String array[] = { "January", "February", "March", "April", "May", "June", "Juliy", "August", "Setember", "October", "November", "December" };
 
   return array[month-1];
  }
}
