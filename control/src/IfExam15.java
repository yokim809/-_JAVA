
public class IfExam15 {

  public static void main(String[] args) {
    String bookName = "";
    int bookPrice = 0;        //책의가격
    int bookAmout = 0;      //책의수량
    int bookTotalPrice = 0;   //책에 수량을 곱한 값
    int point = 0;              // 포인트
    int totalPrice = 0;         //결재금액
    int delivery = 0;           //배송비
    
    bookName = args[0];
    bookPrice = Integer.parseInt(args[1]);
    bookAmout = Integer.parseInt(args[2]);
    
    bookTotalPrice = bookAmout*bookPrice;
    
    if(bookTotalPrice < 20000) {
      delivery = 2500; 
    }
    
    totalPrice = bookTotalPrice + delivery;
    point = (int)(bookTotalPrice * 0.05);
    
    System.out.println("도서명: " + bookName + " | " + "가격: " + bookPrice + " 원" + " | " + "수량: "+ bookAmout + "권");
    System.out.println("배송비: " + delivery);
    System.out.println("-----------------------------------------------");
    System.out.println("도서 가격: " + bookTotalPrice  +" (포인트: " + point + " 원) " + "<- 5 % 계산" );
    System.out.println("결재 금액: " + totalPrice);
    
    
      
    
    
    
    
    
    
    
    

  }

}
