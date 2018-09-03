package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server2 {
  public void server(int port) {
    ServerSocket server = null;      // client �� ���� ��û�� ó��
   
    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����
    
    InputStream is = null;       // ��Ʈ��ũ ����
    InputStreamReader isr = null;     // ���ŵ� �ڵ带 �ѱ۷� ��ȯ
    BufferedReader br = null;     //�޸𸮿� ���     
  
    try {
      server  = new ServerSocket(port);   // 2010
    
      while(true) {   // ���� ��ƾ
        System.out.println("�����ڸ� ��ٸ��� ���Դϴ�.");
        socket = server.accept();    // �����
        inet = socket.getInetAddress();
        System.out.println("���ӵ� Client IP: " + inet.getHostAddress());
        
        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line,"/");
        System.out.println(st.nextToken());
        while(st.hasMoreTokens()){
          System.out.println(st.nextToken());
        }  
        System.out.println("-------------------------");
        
        try {
          br.close();
          isr.close();
          is.close();
          socket.close();
      } catch (Exception e) {
        
      }
     }
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    
    
  }
  
  
}
