package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client2 {
  public void client(String ip, int port) {
    
    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����
    
    OutputStream os = null;       // ��Ʈ��ũ ����
    OutputStreamWriter osw = null;     // ��½� �ѱ��� �ڵ�� ��ȯ ó��
    BufferedWriter bw = null;     //����� �����͸� �޸𸮿� ����
   
    try {
      socket = new Socket(ip,port);   // ������ ���� ��û
      inet = socket.getInetAddress();
      System.out.println("���ӵ� Server IP: " + inet.getHostAddress());

      os = socket.getOutputStream();
      osw = new OutputStreamWriter(os);  // Call By Reference
      bw = new BufferedWriter(osw);
      
      bw.write("[�߱�]/�λ꺣�/[�౸]/��ü���ͽ�Ƽ/[����]/�¿�Į����/");
      bw.flush();     //��Ʈ��ũ ����

      
      bw.close();
      osw.close();
      os.close();    
      socket.close();  
            
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
}
