package oop2;
 
import java.util.Random;
 
public class RndTest {
 
  public static void main(String[] args) {
    int[] members = {0,0,0,0,0,0,0,0,0,0};
    Random rnd = new Random();
    int index = 0;        // �迭 ���� ��ġ
    int su = 0;            // �ϳ��� ����
    boolean sw = false; // ���� ����
    
    while(true) {
      su = rnd.nextInt(30) + 1; // 1 ~ 30
      System.out.println("���� �߻��� ����: " + su);
      
      // ������ ���� �ִ��� �˻�
      for (int i=0; i<= 9; i++) {
        if (members[i] == su) {
          System.out.println("-> �迭�� ����: " + su);
          sw= true;  // �ߺ� �߻�, ������
          break;      // for �� ����
        }
      }
      
      if (sw == false) {
        System.out.println("�迭 " + index + "�� ���ο� �� ����: " + su);
        members[index] = su;
        index = index + 1;
      }
      
      if (index == 10) {
        break;  // while �� ����
      }
      sw = false; // ���� �������� �ʴ� ��츦 ����, �ʱ�ȭ
    }
    System.out.println();
    for (int i=0; i <= 9; i++) {
      System.out.print(members[i] + " ");
    }
  }
 
}