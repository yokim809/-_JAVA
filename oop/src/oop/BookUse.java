package oop;

public class BookUse {

  public static void main(String[] args) {
 
    Book book = new Book();
    
    book.bookName = "�ڹ� ���α׷��� ����";
    book.publisher = "���л�";
    book.bookPrice = 20000;
    book.dc = 10;
    book.dcPrice = (int)(book.bookPrice * (100-book.dc)/100) ;
    
    System.out.println(book.bookName + "   <- ������");
    System.out.println(book.publisher + "                  <- ���ǻ�");
    System.out.println(book.bookPrice + "��              <- ����");
    System.out.println((double)book.dc + "%             <- ������");
    System.out.println(book.dcPrice + "��       <- �ǸŰ�");
    
    
    

  }

}
