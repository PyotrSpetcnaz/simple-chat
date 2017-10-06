import java.io.*;
import java.net.*;

public class ClientInput{

    private static Socket echoSocket;
    private static PrintWriter outputStream;


    public ClientInput(Socket echoSocket) throws IOException{
        this.echoSocket = echoSocket;
        outputStream = new PrintWriter(echoSocket.getOutputStream(), true);

        Form.getInstance().enableSendButton();
        Form.getInstance().addChatMessage("Connected to " + echoSocket.getInetAddress() + ":" + echoSocket.getPort());
    }

    public static void sendText(String message){
        outputStream.println(message);
        Form.getInstance().addChatMessage("Me: " + message + "\n");
    }
}
