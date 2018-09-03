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
    ServerSocket server = null;      // client �� ���� ��û�� ó��

    Socket socket = null;            // ������ �ۼ���
    InetAddress inet = null;         // ���� ����

    InputStream is = null;       // ��Ʈ��ũ ����
    InputStreamReader isr = null;     // ���ŵ� �ڵ带 �ѱ۷� ��ȯ
    BufferedReader br = null;     //�޸𸮿� ���     

    try {
      server  = new ServerSocket(2010);   // 2010

      while(true) {   // ���� ��ƾ
        System.out.println("�����ڸ� ��ٸ��� ���Դϴ�.");
        socket = server.accept();    // �����
        inet = socket.getInetAddress();
        System.out.println("���ӵ� Client IP: " + inet.getHostAddress());

        is = socket.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        
        while(true) {
          String line = br.readLine();
          if(line == null) {
            System.out.println("�µ� ������ �����մϴ�.");
            System.out.println();
            break;
          } else {
            System.out.println(line); //������ �µ��� ���
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
