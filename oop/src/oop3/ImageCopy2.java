package oop3;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ImageCopy2 {
 
  public static void main(String[] args) {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    String img1 = args[0];  //���� ���ϸ�
    String img2 = args[1];  //����� ���ϸ�
    
    try {
      fis = new FileInputStream("C:/ai3/swiss/" + img1);  
      fos = new FileOutputStream(img2);
      
      byte[] buffer = new byte[4096]; // 4 KB, ������ �о ������ �޸� ���� ����
      // buffer: ��ü
      int len = 0; // ���� ����Ʈ��
      int readCount = 0; // ���� Ƚ��
      
      while(true) {
        len = fis.read(buffer); // Call by Reference, 4 KB�� �о� buffer �迭�� ����
        if (len == -1) { // ���� ���������� �˻�
          break;
        } else {
          fos.write(buffer, 0, len); // ���� ����, ����� ���� ��ġ, ����� ����
          readCount++;              // ���� Ƚ�� ���� 
          
          System.out.print("#"); // #: 4KB
          if (readCount % 20 == 0) {
            System.out.println();
          }
        }
      }
 
      File file = new File(img2);
      if (file.exists()) {
        System.out.println();
        System.out.println(file.getName() + " ���� ���� �Ϸ�");
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fis.close();
        fos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
 
}
 