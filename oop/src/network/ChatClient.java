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
    System.out.println("Ŭ���̾�Ʈ ���α׷� �۵�.....");
    try {
      socket = new Socket(ip, port); // ������ ���� �õ�
 
      // socket���κ��� �����͸� �о���� ������
      Thread read = new Thread(new ChatClientRead(socket));
      read.start();  // ChatClientRead -> run() ����
      // Ű���忡�� �Է¹޾� socket���� �����͸� ������ ������
      Thread send = new Thread(new ChatClientSend(socket));
      send.start();  // ChatClientSend -> run() ����
 
    } catch (IOException ioe) {
      System.err.println("������ �Ǿ� ���� �ʽ��ϴ�.");
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
 * �����͸� �о�ɴϴ�.
 * 
 * @author stu
 * 
 */
class ChatClientRead implements Runnable {
  private Socket socket;
  private String line; // �����κ��� �о�� ���ڿ� ����
 
  public ChatClientRead(Socket socket) { // ������
    this.socket = socket;
  }
 
  public void run() {
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      while (true) {
        line = reader.readLine(); // ��Ʈ�����κ��� ���� ����
 
        if (line == null) {
          break;
        }
 
        // ȭ�� ���
        System.out.println("\n" + line);
        System.out.print("ȫ����� ");
      }
    } catch (IOException ignored) {
      System.err.println("������ �Ǿ� ���� �ʽ��ϴ�.");
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
class ChatClientSend implements Runnable {
  private Socket socket;
  private BufferedWriter writer;
  private BufferedReader in;
  private String str = "";
 
  public ChatClientSend(Socket socket) {  // ������
    this.socket = socket;
  }
 
  public void run() {
    try {
      writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // ��Ʈ��ũ ����
      in = new BufferedReader(new InputStreamReader(System.in)); // Ű���� �Է�
 
      while (true) {
        System.out.print("ȫ����� ");
        str = in.readLine(); // Ű����κ��� �Է� ���
        if (str.equals("exit")) {
          break; 
        }
        writer.write("ȫ����� " + str);
        writer.newLine(); // �ٹٲ� ��ȣ�� �־�� BufferedReader�� readLine()�� �ν���
        writer.flush();   // ����
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