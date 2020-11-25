package part1.lesson11.task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server  {

    public static void main(String[] args)   {
        ServerSocket serverSocket ;// Сокет для сервера
        Socket clientSocket;
        BufferedReader in; // Поток для чтения из сокета
        BufferedWriter out; // Поток для записи в сокет
        Set<SomeUser> someUsers = new HashSet<>();

            System.out.println("Сервер запущен");
            try {
                serverSocket = new ServerSocket(12344);

                clientSocket = serverSocket.accept();
                System.out.println(clientSocket);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                System.out.println(in.read());
                String clientMessage = in.readLine();
                System.out.println(clientMessage);
                out.write(clientMessage);
                out.flush();



            }
            catch (Exception e){
                e.printStackTrace();
            }






    }
}
