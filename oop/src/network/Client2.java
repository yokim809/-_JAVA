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
    
    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보
    
    OutputStream os = null;       // 네트워크 전송
    OutputStreamWriter osw = null;     // 출력시 한글을 코드로 변환 처리
    BufferedWriter bw = null;     //출력할 데이터를 메모리에 저장
   
    try {
      socket = new Socket(ip,port);   // 서버에 연결 요청
      inet = socket.getInetAddress();
      System.out.println("접속된 Server IP: " + inet.getHostAddress());

      os = socket.getOutputStream();
      osw = new OutputStreamWriter(os);  // Call By Reference
      bw = new BufferedWriter(osw);
      
      bw.write("[야구]/두산베어스/[축구]/맨체스터시티/[맛집]/태웅칼국수/");
      bw.flush();     //네트워크 전송

      
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
