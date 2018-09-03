package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class CollectServer {

  public static void main(String[] args) {
    ServerSocket server = null;      // client 의 접속 요청을 처리

    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보

    InputStream is = null;       // 네트워크 수신
    InputStreamReader isr = null;     // 수신된 코드를 한글로 변환
    BufferedReader br = null;     //메모리에 기록     

    try {
      server  = new ServerSocket(2010);   // 2010

      while(true) {   // 무한 루틴
        System.out.println("접속자를 기다리는 중입니다.");
        socket = server.accept();    // 대기중
        inet = socket.getInetAddress();
        System.out.println("접속된 Client IP: " + inet.getHostAddress());

        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        while(true) {
          String line = br.readLine();
          if(line == null) {
            System.out.println("온도 수집을 종료합니다.");
            System.out.println();
            break;
          } else {
            System.out.println(line); //수집딘 온도를 출력
          }
        }

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
