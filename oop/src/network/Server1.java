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
    ServerSocket server = null;      // client 의 접속 요청을 처리
    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보
    
    OutputStream os = null;       // 네트워크 전송
    OutputStreamWriter osw = null;     // 출력시 한글을 코드로 변환 처리
    BufferedWriter bw = null;     //출력할 데이터를 메모리에 저장 
    
    try {
      server  = new ServerSocket(port);   // 2010
    
      while(true) {   // 무한 루틴
        System.out.println("접속자를 기다리는 중입니다.");
        socket = server.accept();    // 대기중
        inet = socket.getInetAddress();
        System.out.println("접속된 Client IP: " + inet.getHostAddress());
        
        os = socket.getOutputStream();
        osw = new OutputStreamWriter(os);  // Call By Reference
        bw = new BufferedWriter(osw);
        
        bw.write("[야구]/두산베어스/[축구]/맨체스터시티/[맛집]/태웅칼국수/");
        bw.flush();     //네트워크 전송
        
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
