package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.StringTokenizer;

public class CollectClient {

  public static void main(String[] args) {
    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����
    
    OutputStream os = null;       // ��Ʈ��ũ ����
    OutputStreamWriter osw = null;     // ��½� �ѱ��� �ڵ�� ��ȯ ó��
    BufferedWriter bw = null;     //����� �����͸� �޸𸮿� ����
   
    try {
      socket = new Socket(args[0], Integer.parseInt(args[1]));   // ������ ���� ��û
      inet = socket.getInetAddress();
      System.out.println("���ӵ� Server IP: " + inet.getHostAddress());

      os = socket.getOutputStream();
      osw = new OutputStreamWriter(os);  // Call By Reference
      bw = new BufferedWriter(osw);
      
      while(true) {
        Thread.sleep(3000);
        Random rnd = new Random();
        int temp = rnd.nextInt(11) - 5; //�߻��� �� �ִ� ���� 0~ 10 -> -5 ~ 5
        System.out.println("�µ�: " + temp);
        bw.write(String.valueOf(temp));
        bw.newLine();
        bw.flush();     //��Ʈ��ũ ����
        
        if(temp == -5) {
          System.out.println("������ ������ �����մϴ�.");
          break;
        }
      }

      bw.close();
      osw.close();
      os.close();    
      socket.close();  
            
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
