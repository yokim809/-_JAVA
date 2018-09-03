package network;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
 
/*
 
java network.ChatClient 172.16.7.100
 
*/
public class ChatClient {
  private Socket socket = null;
 
  public void clientStart(String ip, int port) {
    System.out.println("클라이언트 프로그램 작동.....");
    try {
      socket = new Socket(ip, port); // 서버로 접속 시도
 
      // socket으로부터 데이터를 읽어오는 스레드
      Thread read = new Thread(new ChatClientRead(socket));
      read.start();  // ChatClientRead -> run() 실행
      // 키보드에서 입력받아 socket으로 데이터를 보내는 스레드
      Thread send = new Thread(new ChatClientSend(socket));
      send.start();  // ChatClientSend -> run() 실행
 
    } catch (IOException ioe) {
      System.err.println("연결이 되어 있지 않습니다.");
    } finally {
      try {
        if (socket == null) {
          socket.close();
        }
      } catch (IOException ignored) {
      }
    }
 
  }
 
  public static void main(String[] args) {
    ChatClient cc = new ChatClient();
    cc.clientStart(args[0], 2010); // ip, port
  }
}
 
/**
 * 데이터를 읽어옵니다.
 * 
 * @author stu
 * 
 */
class ChatClientRead implements Runnable {
  private Socket socket;
  private String line; // 서버로부터 읽어온 문자열 저장
 
  public ChatClientRead(Socket socket) { // 생성자
    this.socket = socket;
  }
 
  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (true) {
        line = reader.readLine(); // 네트웍으로부터 전송 받음
 
        if (line == null) {
          break;
        }
 
        // 화면 출력
        System.out.println("\n" + line);
        System.out.print("홍길순▶ ");
      }
    } catch (IOException ignored) {
      System.err.println("연결이 되어 있지 않습니다.");
    } finally {
      try {
        socket.close();
      } catch (IOException ignored) {
      }
    }
  }
 
}
 
/**
 * 데이터를 보냅니다.
 * 
 * @author stu
 * 
 */
class ChatClientSend implements Runnable {
  private Socket socket;
  private BufferedWriter writer;
  private BufferedReader in;
  private String str = "";
 
  public ChatClientSend(Socket socket) {  // 생성자
    this.socket = socket;
  }
 
  public void run() {
    try {
      writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 네트워크 전송
      in = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력
 
      while (true) {
        System.out.print("홍길순▶ ");
        str = in.readLine(); // 키보드로부터 입력 대기
        if (str.equals("exit")) {
          break; 
        }
        writer.write("홍길순▷ " + str);
        writer.newLine(); // 줄바뀜 기호가 있어야 BufferedReader의 readLine()이 인식함
        writer.flush();   // 전송
      }
    } catch (Exception ignored) {
 
    } finally {
      try {
        socket.close();
      } catch (IOException ignored) {
      }
    }
  }
} 