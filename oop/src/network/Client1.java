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
    
    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보
    
    InputStream is = null;       // 네트워크 수신
    InputStreamReader isr = null;     // 수신된 코드를 한글로 변환
    BufferedReader br = null;     //메모리에 기록 
    
    try {
      socket = new Socket(ip,port);   // 서버에 연결 요청
      inet = socket.getInetAddress();
      System.out.println("접속된 Server IP: " + inet.getHostAddress());

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
