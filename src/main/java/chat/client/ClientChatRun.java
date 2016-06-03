package chat.client;

/**
 * Created by Alex on 03.06.2016.
 */
public class ClientChatRun {
    private static final String IP = "192.168.0.101";
    private static final int PORT = 5564;
    public static void main(String[] args) {
        ClientChat cc = new ClientChat();
        cc.runClient(IP,PORT);
    }
}
