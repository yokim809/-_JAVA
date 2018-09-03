
public class IfExam11 {

  public static void main(String[] args) {
    String country = args[0];
    int adult = Integer.parseInt(args[1]);
    int child = Integer.parseInt(args[2]);
    int adultprice = 0;
    int childprice = 0;
    int totalPrice = 0;
    
    if(country.equals("일본") == true) {
      adultprice = 600000;
      childprice = 500000;
    } else if(country.equals("중국") == true) {
      adultprice = 400000;
      childprice = 300000;
    } else if(country.equals("대만") == true) {
      adultprice = 500000;
      childprice = 400000;
    }

    totalPrice = (adult*adultprice)+(child*childprice) ;
    
   
     System.out.println("국가: " + country);
     System.out.println("대인: " + adult + " 명 " + (adult*adultprice) +  "원");
     System.out.println("소인: " + child + " 명 " + (child*childprice) +  "원");
     System.out.println("----------------------------");
     System.out.println("결재 금액: " + totalPrice + " 원");
    

      
    
  }

}
