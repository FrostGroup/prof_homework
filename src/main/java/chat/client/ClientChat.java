package chat.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by Alex on 03.06.2016.
 */
public class ClientChat {

    public void runClient(String ip, int port){

        try {
            Socket client = new Socket(ip,port);
            System.out.println("connect");

            DataInputStream is = new DataInputStream(client.getInputStream());
            DataOutputStream os = new DataOutputStream(client.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Write text and press Enter");

            while(true){
                line = reader.readLine();
                os.writeUTF(line);
                os.flush();

                line = is.readUTF();
                System.out.println("Server answer " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
