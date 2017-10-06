import javax.swing.*;
import java.io.*;
import java.net.*;

public class Solution {


    public static void main(String[] args) {
        Form.getInstance();
        int port;

        if (args.length != 1) {
            port = 46764;
        }else{
            port = Integer.parseInt (args[0]);
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket       clientSocket = serverSocket.accept();
            ServerOutput serverOutput = new ServerOutput(serverSocket, clientSocket);
            ClientInput input = new ClientInput(serverSocket, clientSocket);
            Thread in = new Thread(input);
            in.start();
        } catch (IOException e){
            System.out.println("Connection error. Port: " + port);
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}

