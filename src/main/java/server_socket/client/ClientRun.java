package server_socket.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by Alex on 02.06.2016.
 */
public class ClientRun {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.0.101", 8080); //my local IP + port
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line =null;
        StringBuilder sb = new StringBuilder();

        while((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }

        System.out.println(sb.toString());
    }
}
