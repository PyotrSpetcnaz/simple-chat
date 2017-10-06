import java.io.*;
import java.net.*;

public class ServerOutput{

    private static ServerSocket serverSocket;
    private static Socket       clientSocket;
    private static PrintWriter outputStream;

    public ServerOutput(ServerSocket serverSocket, Socket clientSocket) throws IOException{
        this.serverSocket = serverSocket;
        this.clientSocket = clientSocket;

        outputStream = new PrintWriter(clientSocket.getOutputStream(), true);
        Form.getInstance().enableSendButton();
        Form.getInstance().addChatMessage("Someone connected!\n");
    }

    public static void sendText(String message){
        outputStream.println(message);
        Form.getInstance().addChatMessage("Me: " + message + "\n");
    }
}
