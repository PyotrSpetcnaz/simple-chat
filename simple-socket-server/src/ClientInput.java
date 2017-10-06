import java.io.*;
import java.net.*;

public class ClientInput implements Runnable {

    private Socket clientSocket;
    private BufferedReader in;


    public ClientInput(ServerSocket serverSocket, Socket clientSocket) throws IOException{
        this.clientSocket = clientSocket;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        String inputLine;

        try {
            while ((inputLine = in.readLine()) != null) {
                Form.getInstance().addChatMessage("Client: " + inputLine + "\n");
            }
        } catch (IOException e){

        }
    }
}

