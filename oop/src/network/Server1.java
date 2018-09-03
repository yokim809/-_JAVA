package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
  public void server(int port) {
    ServerSocket server = null;      // client �� ���� ��û�� ó��
    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����
    
    OutputStream os = null;       // ��Ʈ��ũ ����
    OutputStreamWriter osw = null;     // ��½� �ѱ��� �ڵ�� ��ȯ ó��
    BufferedWriter bw = null;     //����� �����͸� �޸𸮿� ���� 
    
    try {
      server  = new ServerSocket(port);   // 2010
    
      while(true) {   // ���� ��ƾ
        System.out.println("�����ڸ� ��ٸ��� ���Դϴ�.");
        socket = server.accept();    // �����
        inet = socket.getInetAddress();
        System.out.println("���ӵ� Client IP: " + inet.getHostAddress());
        
        os = socket.getOutputStream();
        osw = new OutputStreamWriter(os);  // Call By Reference
        bw = new BufferedWriter(osw);
        
        bw.write("[�߱�]/�λ꺣�/[�౸]/��ü���ͽ�Ƽ/[����]/�¿�Į����/");
        bw.flush();     //��Ʈ��ũ ����
        
        try {
          bw.close();
          osw.close();
          os.close();    
          socket.close();  
      } catch (Exception e) {
        
      }
     }
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    
    
  }
  
  
}
