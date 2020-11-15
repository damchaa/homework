package part1.lesson11.task1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)   {
        ServerSocket serverSocket ;// Сокет для сервера
        Socket clientSocket;
        BufferedReader in; // Поток для чтения из сокета
        BufferedWriter out; // Поток для записи в сокет
        try {
            serverSocket = new ServerSocket(5555);
            System.out.println("Сервер запущен");
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String clientMessage = in.readLine();
            System.out.println(clientMessage);
            out.write(clientMessage);
            out.flush(); 


        }
        catch (Exception e){

        }



    }
}
