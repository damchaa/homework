package part1.lesson11.task2;

import java.io.*;
import java.net.Socket;

public class SomeUser extends Thread {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

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
                for (SomeUser ct : Server.clientsList) {
                    ct.out.write(clientMessage + "\n");
                    ct.out.flush();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
