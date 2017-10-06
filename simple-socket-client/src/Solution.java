import java.io.*;
import java.net.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        Form form = Form.getInstance();
        String host;
        int port;

        if ( args.length != 2 ) {
            host = "192.168.1.194";
            port = 46764;

        } else {
            host = args[ 0 ];
            port = Integer.parseInt ( args[ 1 ] );
        }

        try {
            Socket       echoSocket   = new Socket(host, port);
            ClientInput clientInput   = new ClientInput(echoSocket);
            ServerOutput output = new ServerOutput(echoSocket);
            Thread out = new Thread(output);
            out.start();
        } catch (IOException e){
            System.out.println("Connection error. Port: " + port);
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
