import java.io.*;
import java.net.*;

public class ServerOutput implements Runnable{

    private Socket ServerSocket;
    private PrintWriter out;
    BufferedReader in;

    public ServerOutput(Socket ServerSocket) throws IOException{
        this.ServerSocket = ServerSocket;
        in  = new BufferedReader (new InputStreamReader (this.ServerSocket.getInputStream()));
    }

    @Override
    public void run() {
        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                Form.getInstance().addChatMessage("Server: " + inputLine + "\n");
            }
        } catch (Exception e){
        }
    }
}
