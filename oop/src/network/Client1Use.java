package network;

public class Client1Use {

  public static void main(String[] args) {
    Client1 client = new Client1();
    
    String ip = args[0];
    int port = 2010;
    
    client.client(ip, port);

  }

}
