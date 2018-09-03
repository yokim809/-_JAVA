
public class IfExam10 {

  public static void main(String[] args) {
    String country = args[0];
    int person = Integer.parseInt(args[1]);
    int price = 0;
    int totalPrice = 0;
    
    if(country.equals("일본") == true) {
      price = 500000;
    } else if(country.equals("중국") == true) {
      price = 300000;
    } else if(country.equals("대만") == true) {
      price = 400000;
    }

    totalPrice = price*person;
    
    if(person >= 1 && person <= 30) {
     System.out.println("국가: " + country);
     System.out.println("대인: " + person + " 명 " + totalPrice +  "원");
     System.out.println("----------------------------");
     System.out.println("결재 금액: " + totalPrice + " 원");
    } else {
        System.out.println("사람수는 1~30까지만 설정 할 수 있습니다.");
    }
      
    
  }

}
