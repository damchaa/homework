package part1.lesson11.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket;
        BufferedReader reader; //для чтения с консоли

        BufferedReader in;
        BufferedWriter out;

        try{
            clientSocket = new Socket("localhost",5555);
            reader = new BufferedReader(new InputStreamReader(System.in));

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("введите текст ");
            String message = reader.readLine();
            out.write(message + "\n");
            out.flush();
            String serverMessage = in.readLine();
            System.out.println(serverMessage);


        }
        catch (Exception e){

        }


    }
}
