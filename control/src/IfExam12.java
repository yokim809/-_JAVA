
public class IfExam12 {

  public static void main(String[] args) {
    String pension ="";
    String barbecue = "";
    String seaSight = "";
    String tube = "";
    int pensionPrice = 0;   //Ææ¼Ç°¡°Ý
    int barbecuePrice = 0;  //¹Ùº£Å¥ °¡°Ý
    int seaSightPrice = 0;    //¹Ù´å°¡ Àü¸Á °¡°Ý
    int tubePrice = 0;        //¹°³îÀÌ Æ©ºê °¡°Ý
    int totalPrice = 0;       //°áÀç±Ý¾×
    pension = args[0];       
    barbecue = args[1];
    seaSight = args[2];
    tube = args[3];
    
    if(pension.equals("Ææ¼Ç1") == true) {
      pensionPrice = 80000;
    } else if(pension.equals("Ææ¼Ç2") == true) {
      pensionPrice = 120000;
    } else if(pension.equals("Ææ¼Ç3") == true) {
      pensionPrice = 150000;
    }
    
    if(barbecue.equals("Y") == true || barbecue.equals("y") == true) {
      barbecuePrice = 30000;
    } 
    if(seaSight.equals("Y") == true || seaSight.equals("y") == true ) {
      seaSightPrice = 20000;
    }
    if(tube.equals("Y") == true || tube.equals("y") == true ) {
      tubePrice = 10000;
    }
 
    totalPrice = pensionPrice + barbecuePrice + seaSightPrice + tubePrice;
    
    System.out.println("Ææ¼Ç: " + pension);
    System.out.println("°¡°Ý: " + pensionPrice + "¿ø");  
    System.out.println("¹Ùº£Å¥: " + barbecuePrice + "¿ø");  
    System.out.println("¹Ù´å°¡Àü¸Á: " + seaSightPrice + "¿ø"); 
    System.out.println("¹°³îÀÌÆ©ºê: " + tubePrice + "¿ø");
    System.out.println("-----------------------------------");
    System.out.println("°áÀç ±Ý¾×: " + totalPrice + " ¿ø");
    

  }

}
