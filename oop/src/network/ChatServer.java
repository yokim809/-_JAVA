package network;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
/*
 
java network.ChatServer
 
*/
public class ChatServer {
 
  private Socket socket = null;
  private ServerSocket server = null;
 
  public void serverStart() {
    System.out.println("접속자를 기다리는 중입니다.");
    try {
      server = new ServerSocket(2010);
      socket = server.accept(); // 진행 중지, 대기
 
      // socket으로부터 데이터를 읽어오는 스레드
      Thread read = new Thread(new ChatServerRead(socket)); // Call By Reference
      read.start();
      // 키보드에서 입력받아 socket으로 데이터를 보내는 스레드
      Thread send = new Thread(new ChatServerSend(socket));
      send.start();
    } catch (IOException ioe) {
      System.err.println("연결이 되어 있지 않습니다.");
    } finally {
      try {
        server.close();
      } catch (IOException ignored) {
      }
    }
 
  }
 
  public static void main(String[] args) {
    ChatServer cs = new ChatServer();
    cs.serverStart();
  }
}
 
/**
 * 데이터를 읽어옵니다.
 * 
 * @author stu
 * 
 */
class ChatServerRead implements Runnable {
  private Socket socket;
  private String line; // 서버로부터 읽어온 문자열 저장
 
  public ChatServerRead(Socket socket) {
    this.socket = socket;
  }
 
  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (true) {
        line = reader.readLine(); // 네트웍으로부터 전송 받음
 
        if (line == null) {
          break; // 종료
        }
        
        System.out.println("\n" + line); // 문자열이 있는 경우 화면 출력
        System.out.print("홍길동▶ ");
      }
 
    } catch (IOException ignored) {
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
class ChatServerSend  implements Runnable {
  private Socket socket;
  private BufferedWriter writer;
  private BufferedReader in;
  private String str = "";
 
  public ChatServerSend(Socket socket) {
    this.socket = socket;
  }
 
  public void run() {
    try {
      writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(System.in));
 
      while (true) {
        System.out.print("홍길동▶ ");
        str = in.readLine(); // 키보드로부터 입력 대기
        if (str.equals("exit")) {
          break; 
        }
        writer.write("홍길동▷ " + str);
        writer.newLine(); // 줄바뀜 기호가 있어야 BufferedReader의 readLine()이 인식함
        writer.flush(); // client로 전송
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