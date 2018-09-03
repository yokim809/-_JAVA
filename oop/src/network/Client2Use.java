package network;

public class Client2Use {

  public static void main(String[] args) {
    Client2 client = new Client2();
    
    String ip = args[0];
    int port = 2010;
    
    client.client(ip, port);

  }

}
