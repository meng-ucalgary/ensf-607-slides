import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Capitalizer implements Runnable {
    private PrintWriter socketOut;
    private BufferedReader socketIn;

    public Capitalizer(BufferedReader socketIn, PrintWriter socketOut) {
        this.socketIn = socketIn;
        this.socketOut = socketOut;
    }

    private void capitalize() {
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

    @Override
    public void run() {
        // TODO Auto-generated method stub
        capitalize();
    }
}
