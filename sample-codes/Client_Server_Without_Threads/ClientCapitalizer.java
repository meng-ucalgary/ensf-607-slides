// package clientServerNoThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCapitalizer {
    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private BufferedReader stdIn;

    public ClientCapitalizer(String serverName, int portNumber) {
        try {
            aSocket = new Socket(serverName, portNumber);
            // keyboard input stream
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

            socketOut = new PrintWriter(aSocket.getOutputStream(), true);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void communicate() {
        String line = "";
        String response = "";

        while (!line.equals("QUIT")) {
            System.out.println("Enter a word to capitalize, or type QUIT to end the program:");

            try {
                line = stdIn.readLine(); // reading from the keyboard (i.e. the user)
                socketOut.println(line);
                response = socketIn.readLine();

                System.out.println("The response is: " + response);
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ClientCapitalizer myClient = new ClientCapitalizer("localhost", 9898);
        myClient.communicate();
    }
}
