package oop2;
 
public class BookUse {
 
  public static void main(String[] args) {
    Book book = new Book(); // �⺻ ������ ȣ��
    book.print();
    
    book = new Book("�ڹ�", 20000, "�մ���"); //������ ȣ��
    book.print();
    
    book.setData("JSP", 25000, "�̷ι�"); //�޼ҵ� ȣ��
    book.print();
    
    Book book2 = new Book("MySQL");
    book2.print();
    
    book2.setData("ȭ�� ħ��");
    book2.print();
  }
 
}