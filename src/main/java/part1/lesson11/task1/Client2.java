package part1.lesson11.task1;

import com.google.gson.Gson;
import part1.lesson11.task2.MessageClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2   {
    static String clientName;
    static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;
    static BufferedReader stdIn;
    static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        clientSocket = new Socket("localhost", 5555);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        part1.lesson11.task2.MessageClient messageClient = new MessageClient();
        String name = readName();
        messageClient.setName(name);



        new Thread() {
            @Override
            public void run() {
                while(true) {

                    try {
                        String mesage = in.readLine();
                        System.out.println(mesage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        System.out.println("1 - для многопользовательского чата,2 для личного сообщения");
        int a = scanner.nextInt();

        switch(a){
            case 1: {
                while(true) {
                    System.out.println("Введите ваше сообщение");
                    String userMessage = stdIn.readLine();
                    if (userMessage.equals("exit")){
                        break;
                    }
                    else {
                        messageClient.setGetter(null);
                        messageClient.setMessage(userMessage);
                        String finalMessage = gson.toJson(messageClient);
                        System.out.println(finalMessage);
                        out.write(finalMessage + "\n");
                        out.flush();
                    }

                }
            }
            case 2:

                System.out.println("Введите имя собеседника");
                String getter = stdIn.readLine();
                System.out.println("Введите ссобщение");
                String message = stdIn.readLine();
                messageClient.setMessage(message);
                messageClient.setGetter(getter);

                String finalMessage = gson.toJson(messageClient);
                System.out.println(finalMessage);
                out.write(finalMessage + "\n");
                out.flush();

        }




    }


    private static String readName() throws IOException {
        System.out.print("Пожалуйста введите имя: ");
        clientName = stdIn.readLine();
        return clientName;
    }
}
