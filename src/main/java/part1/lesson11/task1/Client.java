package part1.lesson11.task1;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket clientSocket;
        BufferedReader in;
        BufferedWriter out;
        ObjectOutputStream objectOutputStream;
        String name;
        String message;
        MessageClient messageClient = new MessageClient();
        name = readName();
        messageClient.setName(name);
        try {
            clientSocket = new Socket("localhost", 12344);
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            while (true) {
                message = readMessage();
                if (message.equals("exit")) {
                    System.out.println(true);
                    break;
                } else {
                    messageClient.setMessage(message);
                    System.out.println(messageClient);

                    Gson gson = new Gson();
                    String m = gson.toJson(messageClient);
                    System.out.println(m);
                    out.write(m.toCharArray());
                    out.flush();

                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    System.out.println(in.readLine());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(messageClient);


    }

    public static String readName() {
        BufferedReader readerName;
        String name;
        try {
            readerName = new BufferedReader(new InputStreamReader(System.in));
            name = readerName.readLine();

            return name;
        } catch (Exception e) {
            System.out.println("Name error");
            return "null";
        }

    }

    public static String readMessage() {
        BufferedReader readerMessage; //для чтения с консоли
        try {
            readerMessage = new BufferedReader(new InputStreamReader(System.in));
            String message = readerMessage.readLine();
            return message;


        } catch (Exception e) {
            System.out.println("error name");
            return "null";
        }

    }
}
