package chat.server;

/**
 * Created by Alex on 03.06.2016.
 */
public class ServerChatRun {
    private static final int PORT = 5564;
    public static void main(String[] args) {
        ServerChat sc = new ServerChat();
        sc.run(PORT);
    }
}
