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
    Socket socket = null;            // 데이터 송수신
    InetAddress inet = null;         // 접속 정보
    
    OutputStream os = null;       // 네트워크 전송
    OutputStreamWriter osw = null;     // 출력시 한글을 코드로 변환 처리
    BufferedWriter bw = null;     //출력할 데이터를 메모리에 저장
   
    try {
      socket = new Socket(args[0], Integer.parseInt(args[1]));   // 서버에 연결 요청
      inet = socket.getInetAddress();
      System.out.println("접속된 Server IP: " + inet.getHostAddress());

      os = socket.getOutputStream();
      osw = new OutputStreamWriter(os);  // Call By Reference
      bw = new BufferedWriter(osw);
      
      while(true) {
        Thread.sleep(3000);
        Random rnd = new Random();
        int temp = rnd.nextInt(11) - 5; //발생할 수 있는 난수 0~ 10 -> -5 ~ 5
        System.out.println("온도: " + temp);
        bw.write(String.valueOf(temp));
        bw.newLine();
        bw.flush();     //네트워크 전송
        
        if(temp == -5) {
          System.out.println("데이터 수집을 종료합니다.");
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
