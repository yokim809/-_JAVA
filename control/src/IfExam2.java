
public class IfExam2 {

  public static void main(String[] args) {
    int rank = Integer.parseInt(args[0]); //���
    String product =""; //��ǰ
    
    if (rank == 1) {
      product = "��Ʈ��";     
    } else if (rank ==2) {
      product = "���� ���� ������";     
    } else if (rank ==3) {
      product = "256 SSD";
    } else {
      product = "���� ��ȸ��...";    
    }
    
    System.out.println("���:" + rank + "��ǰ:" + product);
    
  }
}
