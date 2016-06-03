package chat.server;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 03.06.2016.
 */
public class ServerChat {
    private static final Logger LOGGER = Logger.getLogger(ServerChat.class);
    private int id;
    private List<String> list;

    public ServerChat() {
        list = new ArrayList<>();
    }

    public void run(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server was run");
            Socket client = serverSocket.accept();
            LOGGER.info("Client connect");

            DataInputStream is = new DataInputStream(client.getInputStream());
            DataOutputStream os = new DataOutputStream(client.getOutputStream());

            String line = null;

            while(true){
                line = is.readUTF();
                LOGGER.info("Line is  : " + line);
                id++;
                os.writeUTF("Ok so get next line  " + id + ": message");
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
