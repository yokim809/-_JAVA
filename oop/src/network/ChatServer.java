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
    System.out.println("�����ڸ� ��ٸ��� ���Դϴ�.");
    try {
      server = new ServerSocket(2010);
      socket = server.accept(); // ���� ����, ���
 
      // socket���κ��� �����͸� �о���� ������
      Thread read = new Thread(new ChatServerRead(socket)); // Call By Reference
      read.start();
      // Ű���忡�� �Է¹޾� socket���� �����͸� ������ ������
      Thread send = new Thread(new ChatServerSend(socket));
      send.start();
    } catch (IOException ioe) {
      System.err.println("������ �Ǿ� ���� �ʽ��ϴ�.");
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
 * �����͸� �о�ɴϴ�.
 * 
 * @author stu
 * 
 */
class ChatServerRead implements Runnable {
  private Socket socket;
  private String line; // �����κ��� �о�� ���ڿ� ����
 
  public ChatServerRead(Socket socket) {
    this.socket = socket;
  }
 
  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (true) {
        line = reader.readLine(); // ��Ʈ�����κ��� ���� ����
 
        if (line == null) {
          break; // ����
        }
        
        System.out.println("\n" + line); // ���ڿ��� �ִ� ��� ȭ�� ���
        System.out.print("ȫ�浿�� ");
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
 * �����͸� �����ϴ�.
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
        System.out.print("ȫ�浿�� ");
        str = in.readLine(); // Ű����κ��� �Է� ���
        if (str.equals("exit")) {
          break; 
        }
        writer.write("ȫ�浿�� " + str);
        writer.newLine(); // �ٹٲ� ��ȣ�� �־�� BufferedReader�� readLine()�� �ν���
        writer.flush(); // client�� ����
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