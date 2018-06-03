package HttpServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HttpServer {

    private final Integer port = 8000;

    static HashMap<Integer, String> notes = new HashMap<>();

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.runServer();
    }

    private void runServer() {

        try {


            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {

                Socket socket = serverSocket.accept();

                new Thread(new ConnectionHandler(socket)).start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
