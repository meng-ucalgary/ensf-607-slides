// package clientServerNoThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCapitalizer {
    private Socket aSocket;
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public ServerCapitalizer() {
        try {
            serverSocket = new ServerSocket(9898);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void capitalize() {
        String line = null;
        while (true) {
            try {
                line = socketIn.readLine();
                if (line.equals("QUIT")) {
                    line = "Good Bye!";
                    socketOut.println(line);
                    break;
                }
                line = line.toUpperCase();
                socketOut.println(line);
                // write code to capitalize the word
                // write the capitalized word to the socket
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerCapitalizer myServer = new ServerCapitalizer();

        // Establish a connection
        try {
            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Console at server side says: Connection accepted by the server!");
            myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);

            myServer.capitalize();

            myServer.socketIn.close();
            myServer.socketOut.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
