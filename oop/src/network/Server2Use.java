package network;

public class Server2Use {

  public static void main(String[] args) {
    Server2 server = new Server2();
    
    int port = Integer.parseInt(args[0]);
    server.server(port);
    

  }

}
 