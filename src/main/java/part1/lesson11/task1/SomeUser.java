package part1.lesson11.task1;

import java.io.*;
import java.net.Socket;

public class SomeUser extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    SomeUser(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        start();
    }

    public void run() {
        try {
            while(true) {
                String clientMessage = in.readLine();
                for (SomeUser someUser : Server.clientsList) {
                    someUser.out.write(clientMessage + "\n");
                    someUser.out.flush();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
