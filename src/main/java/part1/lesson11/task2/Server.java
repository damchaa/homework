package part1.lesson11.task2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server  {
    final static int PORT = 5555;
    static List<SomeUser> clientsList = new ArrayList<>();
    private static Socket clientSocket;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Сервер запущен");
        while(true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("get new connection");
                SomeUser сlientThread = new SomeUser(clientSocket);
                clientsList.add(сlientThread);
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}


