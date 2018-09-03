package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client1 {
  public void client(String ip, int port) {
    
    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����
    
    InputStream is = null;       // ��Ʈ��ũ ����
    InputStreamReader isr = null;     // ���ŵ� �ڵ带 �ѱ۷� ��ȯ
    BufferedReader br = null;     //�޸𸮿� ��� 
    
    try {
      socket = new Socket(ip,port);   // ������ ���� ��û
      inet = socket.getInetAddress();
      System.out.println("���ӵ� Server IP: " + inet.getHostAddress());

      is = socket.getInputStream();
      isr = new InputStreamReader(is);
      br = new BufferedReader(isr);
      
      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line,"/");
      
      while(st.hasMoreTokens()){
        System.out.println(st.nextToken());
      }
      
      br.close();
      isr.close();
      is.close();
      socket.close();
          
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
}
