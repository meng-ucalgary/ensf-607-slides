import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCapitalizerWithThreads {
    private Socket aSocket;
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public ServerCapitalizerWithThreads() {
        try {
            serverSocket = new ServerSocket(9898);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerCapitalizerWithThreads myServer = new ServerCapitalizerWithThreads();

        // Establish a connection
        try {
            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Console at server side says: Connection accepted by the server!");
            myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);

            // myServer.capitalize();
            Capitalizer cap1 = new Capitalizer(myServer.socketIn, myServer.socketOut);
            Thread t1 = new Thread(cap1);
            t1.start();

            myServer.aSocket = myServer.serverSocket.accept();
            System.out.println("Console at server side says: Connection accepted by the server!");
            myServer.socketIn = new BufferedReader(new InputStreamReader(myServer.aSocket.getInputStream()));
            myServer.socketOut = new PrintWriter(myServer.aSocket.getOutputStream(), true);

            // myServer.capitalize();
            Capitalizer cap2 = new Capitalizer(myServer.socketIn, myServer.socketOut);
            Thread t2 = new Thread(cap2);
            t2.start();

            try {
                t1.join();
                t2.join();
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

            myServer.socketIn.close();
            myServer.socketOut.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
