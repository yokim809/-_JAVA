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
    ServerSocket server = null;      // client 의 접속 요청을 처리
   
    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보
    
    InputStream is = null;       // 네트워크 수신
    InputStreamReader isr = null;     // 수신된 코드를 한글로 변환
    BufferedReader br = null;     //메모리에 기록     
  
    try {
      server  = new ServerSocket(port);   // 2010
    
      while(true) {   // 무한 루틴
        System.out.println("접속자를 기다리는 중입니다.");
        socket = server.accept();    // 대기중
        inet = socket.getInetAddress();
        System.out.println("접속된 Client IP: " + inet.getHostAddress());
        
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
