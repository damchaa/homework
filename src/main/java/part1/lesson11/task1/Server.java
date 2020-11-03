package part1.lesson11.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socketServer = new ServerSocket(4999);
        while (true){
            try (Socket socket = socketServer.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                 BufferedReader br = new BufferedReader(
                         new InputStreamReader(socket.getInputStream())
                 )
            ){
                String line;
                while ( (line = br.readLine()) != null) {
                    out.println("Echo" + line);
                }
            }

        }


    }
}
