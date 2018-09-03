package network;

public class Server1Use {

  public static void main(String[] args) {
    Server1 server = new Server1();
    
    int port = Integer.parseInt(args[0]);
    server.server(port);
    

  }

}
 