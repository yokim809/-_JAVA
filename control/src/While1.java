
public class While1 {

  public static void main(String[] args) {
    int su = 0;
    
    while(true) { // ���� ��ƾ, ������ ����� ��Ʈ��ũ ������� ���
      su = su + 1;
      System.out.println(su);
      
      if(su == 5) {
        break; // ���� ��ȯ��(while ��) ����
      }
    }
    System.out.println("-----------------------");
    su = 0;
    
    while(su <=4) {
      su = su + 1;
      System.out.println(su);
    }

    
    
  }

}
